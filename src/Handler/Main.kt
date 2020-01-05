package Handler

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun help(){
    println("There are such commands:\n" +
            "/path [directory_path] - the directory where picture(s) is(are)\n" +
            "/path /f [image_path] - the full path to one image\n" +
            "/enc [password] - to encode picture by password\n" +
            "/dec [password] - to decode picture by password\n" +
            "/ex - to exit")
}
fun commandReader():List<String> = readLine().toString().split(' ')

fun menu(){
    var pictures = mutableListOf<BufferedImage>()
    var changedPictures = mutableListOf<BufferedImage>()
    //TODO create loop
    //TODO tell user what to do and how call help
    when(commandReader()[0]){
        "/?" -> help()
        "/path" -> //TODO check dir or file
            File(commandReader()[1]).forEachLine { pictures.add(ImageIO.read(File(it))) }
//        "/enc" -> {
//            for(element in pictures){
//               changedPictures.add(coder.Code(element))
//            }
//        }
        "/dec"-> {

        }
        "/ex" -> return
        else -> {
            println("Wrong command.")
            menu()
        }
    }
}

fun main(args: Array<String>){
    menu()
}
//    test
// var image = ImageIO.read(File("image.jpg"))
// val coder = ImageCoder(mode = "enc", password = "55085508")
//image = coder.Code(image)
//val outputfile = File("image.jpg")
//ImageIO.write(image, "jpg", outputfile)