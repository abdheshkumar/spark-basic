package com.abtechsoft

import org.apache.log4j.{ Level, Logger }
import org.apache.spark.sql.SQLContext
import org.apache.spark.{ SparkConf, SparkContext }

/**
 * Created by abdhesh on 7/18/15.
 */
object SparkSQL extends App {
  val conf = new SparkConf().setMaster("local[4]").setAppName("sparkSQL")
  // run locally with enough threads
  val sc = new SparkContext(conf)

  // Schema for people RDD
  case class Person(name: String, age: Int)

  // Turn off spark's default logger
  Logger.getLogger("org").setLevel(Level.OFF)

  val file = "src/main/resources/data/people.txt"
  // Should be some file on your system
  val data = sc.textFile(file, 4)
  // Create context for Spark SQL
  val sqlContext = new SQLContext(sc)

  import sqlContext.implicits._

  // Convert records of the RDD (people) to Rows.
  val people = data.map(_.split(",")).map(p => Person(p(0), p(1).trim.toInt)).toDF()

  // Register the SchemaRDD as a table.
  people.registerTempTable("people")

}
