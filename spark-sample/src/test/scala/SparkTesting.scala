import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.MILLISECONDS

import com.google.common.base.Stopwatch
import org.scalatest.Matchers
import org.scalatest.time.Milliseconds

class SparkTesting extends SparkSpec with Matchers {

  val MULTIPLIER: Int = 17
  val stopwatch: Stopwatch = new Stopwatch()

  "Spark" should "run simple computation" in {
    val inputList: List[Int] = List(1, 2, 3, 4, 3, 2, 1)

    val resultList: List[Int] = sparkContext.parallelize(inputList).map(multiplyBy(MULTIPLIER)).collect().toList

    resultList.toSeq shouldEqual inputList.map(multiplyBy(MULTIPLIER)).toSeq
  }

  private def multiplyBy(multiplier: Int): (Int) => Int = {
    _ * multiplier
  }

  "Spark" should "count words from file" in {
    val counts = sparkContext.textFile(getClass.getResource("data.txt").toString)
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _) // a,b => a + b

    println(counts.collect().toMap)
  }

  "Spark" should "cache RDDs" in {

    sparkContext.textFile(getClass.getResource("data.txt").toString)

    stopwatch.start()
    var counts = sparkContext.textFile(getClass.getResource("data.txt").toString)
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))//.cache()
      .reduceByKey(_ + _)
      .filter(_._2 > 3) // tuple => tuple._2 > 3

    println(counts.collect().toMap)
    stopwatch.stop()
    println(s"Without cache took: ${stopwatch.elapsed(MILLISECONDS)}")

    stopwatch.reset()
    stopwatch.start()

    counts = sparkContext.textFile(getClass.getResource("data.txt").toString)
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      .filter(_._2 > 3) // tuple => tuple._2 > 3

    println(counts.collect().toMap)
    stopwatch.stop()
    println(s"With cache took: ${stopwatch.elapsed(MILLISECONDS)}")
  }
}
