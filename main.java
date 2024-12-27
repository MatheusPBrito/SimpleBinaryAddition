import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main{

  public static void main (String ... args){
   
    Scanner input = new Scanner(System.in);
    int num1, num2;
    ArrayList<Integer> output = new ArrayList<Integer>();

    while (true) {
      boolean isBinary = false;
      System.out.print("Write the first number: "); 
      if(input.hasNextInt()){
        num1 = input.nextInt();
        input.nextLine();
        String binaryChecker = Integer.toString(num1);
        for(int i = binaryChecker.length() - 1; i > -1; i --){
          if(binaryChecker.charAt(i) != '0' && binaryChecker.charAt(i) != '1'){
            System.out.println("Invalid input");
            break;
          }
          else
            isBinary = true;
        }
        if(isBinary)
          break;
      }
      else{
        System.out.println("Invalid input");
        input.nextLine();
      }
    }

    while (true) {
      boolean isBinary = false;
      System.out.print("Write the second number: "); 
      if(input.hasNextInt()){
        num2 = input.nextInt();
        input.nextLine();
        String binaryChecker = Integer.toString(num2);
        for(int i = binaryChecker.length() - 1; i > -1; i --){
          if(binaryChecker.charAt(i) != '0' && binaryChecker.charAt(i) != '1'){
            System.out.println("Invalid input");
            break;
          }
          else
            isBinary = true;
        }
        if(isBinary)
          break;
      }
      else{
        System.out.println("Invalid input");
        input.nextLine();
      }
    }

    int[] num1Digits = Arrays.stream(String.valueOf(num1).split("")).mapToInt(Integer::parseInt)
    .toArray();
    int[] num2Digits = Arrays.stream(String.valueOf(num2).split("")).mapToInt(Integer::parseInt)
    .toArray();

    if(num1Digits.length > num2Digits.length){
      int checks = 0;
      for(int i = num2Digits.length - 1; i > -1; i--){
        if(num2Digits[i] + num1Digits[num1Digits.length - checks - 1] < 2){
          output.add(num2Digits[i] + num1Digits[num1Digits.length - checks - 1]);
        }
        else if (num2Digits[i] + num1Digits[num1Digits.length - checks - 1] == 2){
          output.add(0);
          num1Digits[num1Digits.length - checks - 2] += 1;
        }
        else if(num2Digits[i] + num1Digits[num1Digits.length - checks - 1] == 3){
          output.add(1);
          num1Digits[num1Digits.length - checks - 2] += 1;
        }
        checks++;
      }

      for(int i = num1Digits.length - num2Digits.length - 1; i > -1; i--){
        if(num1Digits[i] < 2 && i != 0 || num1Digits[i] < 2 && i == 0){
          output.add(num1Digits[i]);
        }
        else if(num1Digits[i] > 1 && i > 0){
          num1Digits[i - 1] += 1;
          if(num1Digits[i] == 2)
            output.add(0);
          else if(num1Digits[i] == 3)
            output.add(1);
        }
        else if(num1Digits[i] > 1 && i == 0) {
          if(num1Digits[i] == 2){
            output.add(0);
            output.add(1);
          }
          else{
            output.add(1);
            output.add(1);
          }
        }
      }
    }
    else if(num1Digits.length < num2Digits.length){
      int checks = 0;
      for(int i = num1Digits.length - 1; i > -1; i--){
        if(num1Digits[i] + num2Digits[num2Digits.length - checks - 1] < 2){
          output.add(num1Digits[i] + num2Digits[num2Digits.length - checks - 1]);
        }
        else if (num1Digits[i] + num2Digits[num2Digits.length - checks - 1] == 2){
          output.add(0);
          num2Digits[num2Digits.length - checks - 2] += 1;
        }
        else if(num1Digits[i] + num2Digits[num2Digits.length - checks - 1] == 3){
          output.add(1);
          num2Digits[num2Digits.length - checks - 2] += 1;
        }
        checks++;
      }

      for(int i = num2Digits.length - num1Digits.length - 1; i > -1; i--){
        if(num2Digits[i] < 2 && i != 0 || num2Digits[i] < 2 && i == 0){
          output.add(num2Digits[i]);
        }
        else if(num2Digits[i] > 1 && i > 0){
          num2Digits[i - 1] += 1;
          if(num2Digits[i] == 2)
            output.add(0);
          else if(num2Digits[i] == 3)
            output.add(1);
        }
        else if(num2Digits[i] > 1 && i == 0) {
          if(num2Digits[i] == 2){
            output.add(0);
            output.add(1);
          }
          else{
            output.add(1);
            output.add(1);
          }
        }
      }
    }
    else{
      for(int i = num1Digits.length - 1; i > -1; i--){

        if(i != 0){
          if(num1Digits[i] + num2Digits[i] < 2){
            output.add(num1Digits[i] + num2Digits[i]);
          }
          else if (num1Digits[i] + num2Digits[i] == 2){
            output.add(0);
            num1Digits[i - i] += 1;
          }
          else if(num1Digits[i] + num2Digits[i] == 3){
            output.add(1);
            num1Digits[i - 1] += 1;
          }
        }
        else{
            if(num1Digits[i] + num2Digits[i] == 2){
              output.add(0);
              output.add(1);
            }
            else{
              output.add(1);
              output.add(1);
            }
        }
      }
    }

    System.out.print("Result: ");
    for (int i = output.size() - 1; i > -1; i--){
      System.out.print(output.get(i));
    }
  }
}
