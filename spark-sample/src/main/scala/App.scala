import org.apache.spark.{SparkConf, SparkContext}

object App {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster(s"local[${Runtime.getRuntime().availableProcessors() - 1}]")
      .setAppName("Simple Application")
    val sc = new SparkContext(conf)

    println(sc.parallelize(List(1, 2, 3, 4, 3, 2, 1)).map(_ * 15).collect().toList)

    sc.stop()
  }
}

