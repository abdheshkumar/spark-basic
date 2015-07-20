import sbt._

object Version {
  val akka      = "2.3.9"
  val hadoop    = "2.7.1"
  val logback   = "1.1.2"
  val mockito   = "1.10.19"
  val scala     = "2.11.7"
  val scalaTest = "2.2.4"
  val slf4j     = "1.7.6"
  val spark     = "1.4.1"
}

object Library {
  val akkaActor      = "com.typesafe.akka" %% "akka-actor"      % Version.akka
  val akkaTestKit    = "com.typesafe.akka" %% "akka-testkit"    % Version.akka
  val logbackClassic = "ch.qos.logback"    %  "logback-classic" % Version.logback
  val mockitoAll     = "org.mockito"       %  "mockito-all"     % Version.mockito
  val scalaTest      = "org.scalatest"     %% "scalatest"       % Version.scalaTest
  val slf4jApi       = "org.slf4j"         %  "slf4j-api"       % Version.slf4j
  val sparkStreaming = "org.apache.spark"  %% "spark-streaming" % Version.spark
  val sparkCore      = "org.apache.spark"  %% "spark-core"      % Version.spark
  val sparktwitter   = "org.apache.spark"  %% "spark-streaming-twitter" % Version.spark
  val sparkSql       = "org.apache.spark"  %% "spark-sql"       % Version.spark
  val sparkMllib     = "org.apache.spark"  %% "spark-mllib"     % Version.spark
  val hadoopClient   = "org.apache.hadoop" %  "hadoop-client"   % Version.hadoop
  //val hadoopcommon   = "org.apache.hadoop" % "hadoop-common"    % "2.6.0" excludeAll ExclusionRule(organization = "org.mortbay.jetty", name = "servlet-api")
}

object Dependencies {
  import Library._

  val sparkAkkaHadoop = Seq(
    sparkStreaming,sparkCore,sparktwitter,sparkSql,sparkMllib,
    akkaActor,
    akkaTestKit,
    hadoopClient,
    logbackClassic % "test",
    scalaTest      % "test",
    mockitoAll     % "test"
  )
}
