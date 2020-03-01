package maybesomeclasses

import scala.io.Source

object Projet_Scala extends App {

  // Import des instructions fournies à la tondeuse.
  var instructions = Source.fromFile("data\\instructions.txt").getLines.toList

  /////////////////////////////////////////////////////////////////////

  // On fixe ici les valeurs maximales prisent par le terrain sur lequel évolue la tondeuse.
  // Les valeurs maximales sont extraites du fichier texte tandis que les valeurs minimales sont fixées à 0.
  // Attention: ici nous traitons un cas où les coordonnées ne peuvent être que positive.
  val xmax: Int = instructions(0).split(" ")(0).toInt
  val ymax: Int = instructions(0).split(" ")(1).toInt
  val xmin: Int = 0
  val ymin: Int = 0

  // UNe fois les paramètres du jardin assigné, nous les supprimons de la liste d'instruction.
  var listofmov = instructions.splitAt(1)

  var listofmov2 = listofmov._2
  println(listofmov2.getClass)

  // Instructions de la tondeuse 1.
  var tondeuse1 = listofmov2.take(2)
  println(tondeuse1)

  // Instructions de la tondeuse 2.
  var tondeuse2 = listofmov2.takeRight(2)
  println(tondeuse2)
  /////////////

  // On définit ici une fonction qui permettra à chacune des deux tondeuses de se déplacer sur le terrain en suivant les
  // instructions prédéfinies précédemmnt.
  def Tonte_de_la_pelouse(tondeusename: List[String])= {

    if (tondeusename == tondeuse1) {
      println("La tondeuse numéro 1 commence son mouvement")
    } else {
      println("La tondeuse numéro 2 commence son mouvement")
    }

    val firstorient: String = tondeusename(0).split(" ")(2).toString
    val firstposition = List(tondeusename(0).split(" ")(0).toInt, tondeusename(0).split(" ")(1).toInt)
    val path2 = tondeusename(1).toList
    val path = path2.map(_.toString)

    // La taille de la matrice qui représente le terrain sur lequel la matrice va évoluer
    println(s"Le terrain est d'une taille : ${xmax} x ${ymax}")

    var x: Int = firstposition(0)
    var y: Int = firstposition(1)
    var orient: String = firstorient
    println(s"Position initiale: ${x} / ${y} / ${orient}")

    for (step <- path) {

      if (step == "G") {
        if (orient == "N") {
          orient = "O"
        }
        else if (orient == "E") {
          orient = "N"
        }
        else if (orient == "O") {
          orient = "S"
        }
        else if (orient == "S") {
          orient = "E"
        }
        else {
          orient = "error"
        }
      }
      else if (step == "D") {
        if (orient == "N") {
          orient = "E"
        }
        else if (orient == "E") {
          orient = "S"
        }
        else if (orient == "O") {
          orient = "N"
        }
        else if (orient == "S") {
          orient = "O"
        }
        else {
          orient = "error"
        }
      }
      // On définit ici les mouvement de la tondeuse
      else if (step == "A") {

        if (orient == "N" & y < ymax) {
          y = y + 1
        }
        else if (orient == "O" & x > xmin) {
          x = x - 1
        }
        else if (orient == "E" & x < xmax) {
          x = x + 1
        }
        else if (orient == "S" & y > ymin) {
          y = y - 1
        }

      }
      // On définit ici que si la somme de chaque itération dépasse la taille prédéfinie de la dimension du jardin, alors la valeur ne changera pas.
      else {
        println("Autre problème")
      }
      println(s"Position acutelle: ${x} / ${y} / ${orient}")
    }
    println(s"Position finale: ${x} / ${y} / ${orient}")
  }
  // Utilisation de la fonction, il n'y a plus qu'à choisir quelle tondeuse utiliser.
  // On pourra aussi changer les paramètres de déplacement s'il on le souhaite ou bien modifier les paramètres du terrain.
  Tonte_de_la_pelouse(tondeuse2)
}
