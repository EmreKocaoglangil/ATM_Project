import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer CustomerObj = new Customer();
                 // ID Şifre Talep et
        for(int counter = 2; counter >= 0; counter--){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your ID");
        String ID = scan.next();
        System.out.println("Please enter your Password");
        String Pass = scan.next();
        System.out.println("Please select your image with pressing the number.First one is the true");
        System.out.println("1-https://evrimagaci.org/public/content_media/ee1b702dbed730ed8f7142c19aa33ab6.jpg\n2-https://www.petihtiyac.com/Data/Blog/1/198.jpg");


        //ID Şifre Doğru mu kontrol et 3 Hak ver


          if(ID.equals(CustomerObj.username) && Pass.equals(CustomerObj.password) && image().equals(CustomerObj.image)){
              try{
                  BufferedWriter writer = new BufferedWriter(new FileWriter("Logger.txt",true));
                  writer.write("ID Şifre Doğru Sisteme Giriş Yapıldı");
                  writer.close();
              }catch (IOException e){
                  e.printStackTrace();
              }
            System.out.println("ID ve Şifreniz Doğru ");
              System.out.print("Lütfen Yapmak istediğiniz işlemi sayısını girerek seçiniz!" + "\n"+ "0 - Parayı görüntüle" + "\n"+ "1 - Para yatır" + "\n"+ "2 - Para çek" + "\n"+ "3 - EFT yap" + "\n"+ "4 - Havale yap" + "\n"+ "5 - Sahte Mail" + "\n"+ "6 - Sistemden çık"+ "\n" );

              int scannedChoose = scan.nextInt();
              switch (scannedChoose){
                  case 0:

                      showMoney();
                      break;

                  case 1:

                      addMoney();
                      break;

                  case 2:

                      withdrawingMoney();
                      break;

                  case 3:

                      transfer();

                      break;
                  case 4:
                      transfer();

                      break;
                  case 5:
                      fakeMail();
                      break;
                  case 6:
                      System.exit(0);

              }
            return;
        }
          else{
            if(counter == 0){
                System.out.println("Malesef hakkınız kalmadı sistemden atılıyorsunuz");
                System.exit(0);

            }else {
                System.out.println("Şifre yanlış " + counter + " hakkınız kaldı!");
            }
        }


    }
}
    private static void fakeMail(){
        Customer CustomerObj = new Customer();
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen  alıcının mailini yazınız");
        String toMail = scan.next();
        System.out.println( toMail + " adresine bilgi maili gönderildi.");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Logger.txt",true));
            writer.append(CustomerObj.username +" tarafından" + toMail +" adresine mail gönderme işlemi gerçekleşti. " );
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void addMoney(){
        Customer CustomerObj = new Customer();
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen yatırmak istediğiniz para miktarını belirtiniz.");
        int depositMoney = scan.nextInt();
        CustomerObj.money+=depositMoney;
        System.out.println("Toplam paranız " +CustomerObj.money + " TL olmuştur." );
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Logger.txt",true));
            writer.append("\nHesaba para eklendi.\nYeni hesap bakiyesi " + CustomerObj.money + " TL olmuştur. " );
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void showMoney(){
        Customer CustomerObj = new Customer();
        System.out.println("Hesabınızdaki para miktarı " + CustomerObj.money + " TL dir");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Logger.txt",true));
            writer.append("\nHesaptaki paraya bakıldı. ");
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private static void withdrawingMoney(){
        Customer CustomerObj = new Customer();
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen çekmek istediğiniz para miktarını belirtiniz.");
        int withdrawnMoney = scan.nextInt();
        if(withdrawnMoney <= CustomerObj.money){
        CustomerObj.money-=withdrawnMoney;
        System.out.println("Hesabınızdan "+ withdrawnMoney + " TL para çekilmiştir."+ "\nGüncel paranız "+ CustomerObj.money + " TL olmuştur");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Logger.txt",true));
            writer.append("\nHesaptan " + withdrawnMoney +"para çekildi.\n Yeni hesap bakiyesi " + CustomerObj.money + " TL olmuştur. " );
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }}else System.out.println("Çekmek istediğiniz para mikarı ana para miktarını geçemez ! \nLütfen sisteme tekrar giriş yapınız");
    }
    private static void transfer(){
        Customer CustomerObj = new Customer();
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen göndermek istediğiniz kişinin IBAN numarasını giriniz");
        long ibanNo=scan.nextLong();
        System.out.println("Lütfen göndermek istediğiniz para miktarını belirtiniz.");
        int sendingMoney = scan.nextInt();
        if(sendingMoney <= CustomerObj.money){
        fakeMail();
        CustomerObj.money-=sendingMoney;
        System.out.println("Hesabınızdan "+ sendingMoney + " TL para "+ ibanNo +" Numaralı ibana gönderilmiştir." + "\nGüncel paranız "+ CustomerObj.money + " TL olmuştur");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Logger.txt",true));
            writer.append("\nHesaptan " + sendingMoney +"para" + ibanNo +"ibanına gitmiştir" + "\n Yeni hesap bakiyesi " + CustomerObj.money + " TL olmuştur. " );
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }}
        else System.out.println("Göndermek istediğiniz para miktarı ana parayı geçemez!\n Lütfen sisteme tekrar giriş yapınız");
    }
    private static String image(){
        Scanner scan = new Scanner(System.in);
        int selectedimg =scan.nextInt();
        switch (selectedimg){
            case 1:
                return "https://evrimagaci.org/public/content_media/ee1b702dbed730ed8f7142c19aa33ab6.jpg";

            case 2:
                return "https://www.petihtiyac.com/Data/Blog/1/198.jpg";

        }return "You did something wrong";
    }


}