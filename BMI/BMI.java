import java.util.Scanner;
import java.util.InputMismatchException;
public class BMI
{
	public static void main(String[]args)
	{
		Scanner about = new Scanner(System.in);
		Scanner decision = new Scanner(System.in);
		Scanner name = new Scanner(System.in);
		Scanner age = new Scanner(System.in);
		Scanner weight = new Scanner(System.in);
		Scanner height = new Scanner(System.in);
		Scanner Stop = new Scanner(System.in);
		Scanner nav = new Scanner(System.in);
		Scanner choice = new Scanner(System.in);
		
		int choose;
		
		label:
		while(true)
		{
			System.out.print("\u001B[1;97m");
			System.out.print("\033[H\033[2J");
			System.out.println("\n");
			System.out.println("(1) Easy Mode");
			System.out.println("(2) Advanced Mode");
			System.out.println("(3) Exit");
			System.out.println("\u001B[0m");
		
		
			try
			{
				choose = choice.nextInt();
			}
			
			catch(InputMismatchException e)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;91mPlease Choose Only 1-2");
				System.out.println("\u001B[0m");
				choice.nextLine();
				choice.nextLine();
				System.out.print("\033[H\033[2J");  
				System.out.flush();
				continue;
			}
			
			while(choose !=1 && choose !=2 && choose !=3)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;91mPlease Choose Only 1-4");
				System.out.println("\u001B[0m");
				choice.nextLine();
				choice.nextLine();
				System.out.print("\033[H\033[2J");   //reset screen
				System.out.flush();
				continue label;
			}
			break;
		}

		switch(choose)
		{
			case 1:
				ShowEasyMode(about, decision, name, age, weight, height, Stop, nav); 
				break;
			case 2:
				ShowMenu(about, decision, name, age, weight, height, Stop, nav);
			case 3:
				System.exit(0);
		}
		choice.close();
	}
	
	private static void ShowEasyMode(Scanner about, Scanner decision, Scanner name, Scanner age, Scanner weight, Scanner height, Scanner Stop, Scanner nav)
	{
		int last;
		float heights, weights, cheight, bmi;
		
		System.out.print("\033[H\033[2J");
		
		label:
		while(true)
		{
			System.out.println("\u001B[1;36mBody Mass Index Calculator\n\n");
			System.out.print("\u001B[0m");
			
			System.out.print("\u001B[1;33mEnter Your Height (cm): ");
			System.out.print("\u001B[0m");
			System.out.print("\u001B[1;97m");
			
			try
			{
				heights = height.nextFloat();
				System.out.print("\u001B[0m");
			}
			
			catch(InputMismatchException e)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;91mInvalid Please Put Corrrect Value");
				System.out.println("\u001B[0m");
				height.nextLine();
				height.nextLine();
				System.out.print("\033[H\033[2J");  
				System.out.flush();
				continue label;
			}
			
			try
			{
				System.out.print("\u001B[1;33mEnter Your Weight (kg): ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m");
				weights = weight.nextFloat();
				System.out.print("\u001B[0m");
			}
			
			catch(InputMismatchException e)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;91mInvalid Please Put Corrrect Value");
				System.out.println("\u001B[0m");
				weight.nextLine();
				weight.nextLine();
				System.out.print("\033[H\033[2J");  
				System.out.flush();
				continue label;
			}
			break;
		}	
		
		System.out.print("\033[H\033[2J");
		cheight = (heights * 0.01f);
		bmi = weights / (cheight * cheight);
		
		if(bmi <= 18.5)
		{	
			label:
			while(true)
			{
				System.out.print("\033[H\033[2J");
				System.out.print("\u001B[1;33mYour BMI is: ");
				System.out.print("\u001B[0m");
					
				System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi);
				System.out.println("\u001B[0m");					
				System.out.print("\u001B[1;33mClassification: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m\u001B[4;37mUnderweight");
				System.out.println("\u001B[0m\n\n");
				System.out.println("\u001B[1;32mPress Enter to Continue...");
				System.out.print("\u001B[0m");
				nav.nextLine();
					
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;32m");
				System.out.println("\u001B[1;33m ___________________");
				System.out.println("\u001B[1;33m|                   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (3) Advanced Mode \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (4) Exit       \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|___________________|");
				System.out.print("\u001B[0m");
				
				try
				{
					last = Stop.nextInt();
				}
						
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					Stop.nextLine();
					Stop.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
							
				while(last < 1 || last > 4)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					nav.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue label;
				}
					
				switch(last)
				{
					case 1:
						continue;
					case 2:
						ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
					case 3:
						ShowMenu(about, decision, name, age, weight, height, Stop, nav);
					case 4:
						System.exit(0);
				}
				break;
			}	
		}
	
		
		else if(bmi <= 24.9)
		{
			label:
			while(true)
			{
				System.out.print("\033[H\033[2J");
				System.out.print("\u001B[1;33mYour BMI is: ");
				System.out.print("\u001B[0m");
				
				System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi);
				System.out.println("\u001B[0m");					
				System.out.print("\u001B[1;33mClassification: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m\u001B[4;37mNormal");
				System.out.println("\u001B[0m\n\n");
				System.out.println("\u001B[1;32mPress Enter to Continue...");
				System.out.print("\u001B[0m");
				nav.nextLine();
				
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;32m");
				System.out.println("\u001B[1;33m ___________________");
				System.out.println("\u001B[1;33m|                   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (3) Advanced Mode \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (4) Exit       \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|___________________|");
				System.out.print("\u001B[0m");
			
				try
				{
					last = Stop.nextInt();
				}
						
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					Stop.nextLine();
					Stop.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
							
				while(last < 1 || last > 4)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					nav.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue label;
				}
					
				switch(last)
				{
					case 1:
						continue;
					case 2:
						ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
					case 3:
						ShowMenu(about, decision, name, age, weight, height, Stop, nav);
					case 4:
						System.exit(0);
				}
			}
		}
	
		
		else if(bmi <= 30)
		{
			label:
			while(true)
			{
				System.out.print("\033[H\033[2J");
				System.out.print("\u001B[1;33mYour BMI is: ");
				System.out.print("\u001B[0m");
			
				System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi);
				System.out.println("\u001B[0m");					
				System.out.print("\u001B[1;33mClassification: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m\u001B[4;37mOverweight");
				System.out.println("\u001B[0m\n\n");
				System.out.println("\u001B[1;32mPress Enter to Continue...");
				System.out.print("\u001B[0m");
				nav.nextLine();
					
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;32m");
				System.out.println("\u001B[1;33m ___________________");
				System.out.println("\u001B[1;33m|                   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (3) Advanced Mode \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (4) Exit       \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|___________________|");
				System.out.print("\u001B[0m");
						
				try
				{
					last = Stop.nextInt();
				}
						
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					Stop.nextLine();
					Stop.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
								
				while(last < 1 || last > 4)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					nav.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue label;
				}
					
				switch(last)
				{
					case 1:
						continue;
					case 2:
						ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
					case 3:
						ShowMenu(about, decision, name, age, weight, height, Stop, nav);
					case 4:
						System.exit(0);
				}
			}
		}
	
		
		
		else
		{
			label:
			while(true)
			{
				System.out.print("\033[H\033[2J");
				System.out.print("\u001B[1;33mYour BMI is: ");
				System.out.print("\u001B[0m");
			
				System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi);
				System.out.println("\u001B[0m");					
				System.out.print("\u001B[1;33mClassification: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m\u001B[4;37mObese");
				System.out.println("\u001B[0m\n\n");
				System.out.println("\u001B[1;32mPress Enter to Continue...");
				System.out.print("\u001B[0m");
				nav.nextLine();
					
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;32m");
				System.out.println("\u001B[1;33m ___________________");
				System.out.println("\u001B[1;33m|                   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|\u001B[1;32m (3) Advanced Mode \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (4) Exit       \u001B[1;33m   |");
				System.out.println("\u001B[1;33m|___________________|");
				System.out.print("\u001B[0m");
							
				try
				{
					last = Stop.nextInt();
				}
						
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					Stop.nextLine();
					Stop.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
							
				while(last < 1 || last > 4)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-4");
					System.out.println("\u001B[0m");
					nav.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue label;
				}
					
				switch(last)
				{
					case 1:
						continue;
					case 2:
						ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
					case 3:
						ShowMenu(about, decision, name, age, weight, height, Stop, nav);
					case 4:
						System.exit(0);
				}
			}
		}
	
	}
	
	private static void ShowMenu(Scanner about, Scanner decision, Scanner name, Scanner age, Scanner weight, Scanner height, Scanner Stop, Scanner nav) 
	{
		System.out.print("\033[H\033[2J");
		int menu;
		
		label:
		while(true) 
		{
			System.out.println("\u001B[1;96m\u001B[4;36mBody Mass Index Calculator\n\n");
			System.out.println("\u001B[0m");
			System.out.print("\u001B[1;95m      Menu");
			System.out.print("\u001B[0m");
			System.out.println("\u001B[1;32m"); //purple \u001B[1;35m
			
			System.out.println("\u001B[1;33m ________________");
			System.out.println("\u001B[1;33m|                |");
			System.out.println("\u001B[1;33m|\u001B[1;32m (1) About      \u001B[1;33m|");
			System.out.println("\u001B[1;33m|\u001B[1;32m (2) Members    \u001B[1;33m|");
			System.out.println("\u001B[1;33m|\u001B[1;32m (3) Calculator \u001B[1;33m|");
			System.out.println("\u001B[1;33m|\u001B[1;32m (4) Easy Mode  \u001B[1;33m|");
			System.out.println("\u001B[1;33m|\u001B[1;32m (5) Exit       \u001B[1;33m|");
			System.out.println("\u001B[1;33m|________________|");
			System.out.println("\u001B[0m");
			
			try
			{
				menu = about.nextInt();
			}
				
			catch(InputMismatchException e)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;91mPlease Choose Only 1-5");
				System.out.println("\u001B[0m");
				about.nextLine();
				about.nextLine();
				System.out.print("\033[H\033[2J");  
				System.out.flush();
				continue;
			}
			
			while(menu < 1 || menu > 5)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;91mPlease Choose Only 1-5");
				System.out.println("\u001B[0m");
				about.nextLine();
				about.nextLine();
				System.out.print("\033[H\033[2J");   //reset screen
				System.out.flush();
				continue label;
			}
			break;
		}
		
		switch(menu)
		{
			case 1:
				ShowAbout(about, decision, name, age, weight, height, Stop, nav);
				break;
			case 2:
				ShowMembers(about, decision, name, age, weight, height, Stop, nav);
				break;
			case 3:
				ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
				break;
			case 4:
				ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
			case 5: 
				System.exit(0);
				break;
		}
	}
	
	private static void ShowAbout(Scanner about, Scanner decision, Scanner name, Scanner age, Scanner weight, Scanner height, Scanner Stop, Scanner nav)
	{
		int decide;
		
		try
		{
			System.out.print("\033[H\033[2J");  
				
			System.out.println("\u001B[0;92m                                                     About");
			System.out.println("\u001B[0m");
				
			System.out.println("\u001B[1;36mAbout BMI Calculator"); //cyan
			System.out.println("\u001B[0m"); //default color //yellow
			Thread.sleep(0100);
			System.out.println("\u001B[1;33mWelcome to our BMI Calculator, your go-to tool for assessing your Body Mass Index (BMI) and gaining insights into your ");
			System.out.println("overall health. Understanding your BMI is a crucial step in maintaining a healthy lifestyle and making informed ");
			System.out.print("decisions about your well-being.");
			System.out.println("\u001B[0m\n");
				
			System.out.println("\u001B[1;36mWhat is BMI?");
			System.out.println("\u001B[0m");
			Thread.sleep(0100);
			System.out.println("\u001B[1;33mBMI is a numerical representation of your body composition based on your weight and height. It is a widely used ");
			System.out.print("indicator to assess whether you are underweight normal weight, overweight, or obese.");
			System.out.println("\u001B[0m\n");
				
			System.out.println("\u001B[1;36mHow to Use the BMI Calculator");
			System.out.println("\u001B[0m");
			Thread.sleep(0100);
			System.out.println("\u001B[1;33mUsing our user-friendly BMI calculator is quick and simple. Just input your height and weight, and let the calculator do");
			System.out.print("the rest. The result will provide you with your BMI score, along with its classification.");
			System.out.println("\u001B[0m");
				
			nav.nextLine();	
			
			label:
			while(true)
			{
				System.out.print("\033[H\033[2J"); 
					
				System.out.println("\u001B[1;36mBMI Classification\n");
				System.out.println("\u001B[0m");
					
				System.out.print("\u001B[1;35mUnderweight: ");
				System.out.print("\u001B[0m");
				Thread.sleep(0100);
				System.out.print("\u001B[1;33m BMI less than 18.5");
				System.out.println("\u001B[0m");
					
				System.out.print("\u001B[1;35mNormal: ");
				System.out.print("\u001B[0m");
				Thread.sleep(0100);
				System.out.print("\u001B[1;33m      BMI 18.5 to 24.9");
				System.out.println("\u001B[0m");
					
				System.out.print("\u001B[1;35mOverweight: ");
				System.out.print("\u001B[0m");
				Thread.sleep(0100);
				System.out.print("\u001B[1;33m  BMI 25 to 29.9");
				System.out.println("\u001B[0m");
					
				System.out.print("\u001B[1;35mObese: ");
				System.out.print("\u001B[0m");
				Thread.sleep(0100);
				System.out.print("\u001B[1;33m       BMI 30 and above");
				System.out.println("\u001B[0m\n\n\n");
			
				System.out.println("\u001B[1;32m");
				System.out.println("\u001B[1;33m ________________");
				System.out.println("\u001B[1;33m|                \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go back    \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m|");
				System.out.println("\u001B[1;33m|________________|");
				System.out.println("\u001B[0m");
				
				try
				{
					decide = decision.nextInt();
				}	
					
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-2");
					System.out.println("\u001B[0m");
					decision.nextLine();
					decision.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
				
				while(decide !=1 && decide !=2)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-2");
					System.out.println("\u001B[0m");
					decision.nextLine();
					decision.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue label;
				}
				break;
			}
			
			switch(decide)
			{
				case 1:
					ShowMenu(about, decision, name, age, weight, height, Stop, nav);
					break;
				case 2:
					ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
					break;
			}
		}	
		
		catch(InterruptedException e)
		{
			System.out.flush();
		}
	}
	
	private static void ShowMembers (Scanner about, Scanner decision, Scanner name, Scanner age, Scanner weight, Scanner height, Scanner Stop, Scanner nav)
	{
		int decide;
		try
		{
			label:
			while(true)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;32m<--Made by-->");
				System.out.print("\u001B[0m");
				Thread.sleep(0100);
				System.out.println("\u001B[1;33mCode Crafters");
				System.out.println("\u001B[0m");
				
				System.out.println("\u001B[1;32m<--Lead Programmer-->"); //green
				Thread.sleep(0100);
				System.out.println("\u001B[1;33mOrdovez, Earl Romeo B.");
				System.out.println("\u001B[0m");
				
				System.out.println("\u001B[1;35m<--From Gordon College-->");
				System.out.print("\u001B[0m");
				Thread.sleep(0100);
				System.out.println("\u001B[1;36mCSS - BSIT");
				System.out.println("\u001B[0m");
			
			
				System.out.println("\u001B[1;32m");
				System.out.println("\u001B[1;33m ________________");
				System.out.println("\u001B[1;33m|                \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go back    \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m|");
				System.out.println("\u001B[1;33m|________________|");
				System.out.println("\u001B[0m");
				
				try
				{
					decide = decision.nextInt();
				}
				
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-2");
					System.out.println("\u001B[0m");
					decision.nextLine();
					decision.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
				
				while(decide !=1 && decide !=2)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-2");
					System.out.println("\u001B[0m");
					decision.nextLine();
					decision.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue label;
				}
				break;
			}
			
			switch(decide)
			{
				case 1:
					ShowMenu(about, decision, name, age, weight, height, Stop, nav);
					break;
				case 2:
					ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
					break;
			}
		}
		
		catch(InterruptedException e)
		{
			System.out.flush();
		}
	}
	
	private static void ShowCalculator (Scanner about, Scanner decision, Scanner name, Scanner age, Scanner weight, Scanner height, Scanner Stop, Scanner nav)
	{
		int decide, ages, last;
		String names;
		float heights, weights, cheight, bmi;
		
		try
		{
			while(true)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;36m");
				System.out.println("Welcome to BMI Calculator");
				System.out.println("Tips and Classication");
				System.out.println("\u001B[0m");
				
				System.out.print("\u001B[1;33mEnter Your Name: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m");
				names = name.nextLine();
				System.out.print("\u001B[0m");
			
				System.out.print("\u001B[1;33mEnter Your Age: ");
				System.out.print("\u001B[0m");
				try
				{
					System.out.print("\u001B[1;97m");
					ages = age.nextInt();
					System.out.print("\u001B[0m");
				}
				
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Put Correct Value...");
					System.out.println("\u001B[0m");
					age.nextLine();
					age.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
				
				if(ages ==2000)
				{
					System.exit(0);
				}
	
				System.out.print("\u001B[1;33mEnter Your Height (cm): ");
				System.out.print("\u001B[0m");
				try
				{
					System.out.print("\u001B[1;97m");
					heights = height.nextFloat();
					System.out.print("\u001B[0m");
				}
				
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Put Correct Value...");
					System.out.println("\u001B[0m");
					height.nextLine();
					height.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
			
				System.out.print("\u001B[1;33mEnter Your Weight (kg): ");
				System.out.print("\u001B[0m");
				try
				{
					System.out.print("\u001B[1;97m");
					weights = weight.nextFloat();
					System.out.print("\u001B[0m");
				}
				
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Put Correct Value...");
					System.out.println("\u001B[0m");
					weight.nextLine();
					weight.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
				break;
			}
			
			weight.nextLine();
			System.out.println("\u001B[0m");
			
			label:
			while(true)
			{
				System.out.print("\033[H\033[2J");
				System.out.println("\u001B[1;36m");
				System.out.println("Welcome to BMI Calculator");
				System.out.println("Tips and Classication");
				System.out.println("\u001B[0m\n");
					
				System.out.println("\u001B[1;91mPlease Confirm!");
				
				System.out.println("\u001B[1;32m******************************");
				System.out.print("\u001B[0m");
					
				System.out.print("\u001B[1;33mName: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m"); //white
		
				System.out.println(names);
				System.out.print("\u001B[0m");
					
				System.out.print("\u001B[1;33mAge: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m");

				System.out.println(ages);
				System.out.print("\u001B[0m");
					
				System.out.print("\u001B[1;33mHeight: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m");

				System.out.println(heights);
				System.out.print("\u001B[0m");
				
				System.out.print("\u001B[1;33mWeight: ");
				System.out.print("\u001B[0m");
				System.out.print("\u001B[1;97m");
				
				System.out.println(weights);
				System.out.print("\u001B[0m");
					
				System.out.println("\u001B[1;32m******************************");
				System.out.println("\u001B[0m");
				
				System.out.println("\u001B[0;35m");
				System.out.println("\u001B[1;33m _____________________");
				System.out.println("\u001B[1;33m|                     \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m Press 1 to Continue \u001B[1;33m|");
				System.out.println("\u001B[1;33m|\u001B[1;32m Press 2 to Go Back  \u001B[1;33m|");
				System.out.println("\u001B[1;33m|_____________________|");
				System.out.println("\u001B[0m");
				
				try
				{
					decide = decision.nextInt();
				}
					
				catch(InputMismatchException e)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-2");
					System.out.println("\u001B[0m");
					decision.nextLine();
					decision.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue;
				}
					
				while(decide !=1 && decide !=2)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;91mPlease Choose Only 1-2");
					System.out.println("\u001B[0m");
					decision.nextLine();
					decision.nextLine();
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					continue label;
				}
				break;
			}		
				
			if(decide==2)
			{
				ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
			}
			else if(decide==1)
			{
				System.out.print("\033[H\033[2J");
				cheight = (heights * 0.01f);
				bmi = weights / (cheight * cheight);
				
				if(bmi <= 18.5)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;36m");
					System.out.println("Welcome to BMI Calculator");
					System.out.println("Tips and Classication");
					System.out.println("\u001B[0m\n");
					
					System.out.print("\u001B[1;33mYour BMI is:");
					System.out.print("\u001B[0m");
					
					System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi); //white underline
					System.out.println("\u001B[0m");
					
					System.out.print("\u001B[1;33mClassification: ");
					System.out.print("\u001B[0m");
					System.out.print("\u001B[1;97m\u001B[4;37mUnderweight");
					System.out.println("\u001B[0m\n\n");
					System.out.println("\u001B[1;32mPress Enter to Continue...");
					System.out.print("\u001B[0m");
					nav.nextLine();
					
					label: //underweight
					while(true)
					{
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;36m");//cyan
						System.out.println("Tips");
						System.out.print("Classification: ");
						System.out.print("\u001B[0m");
						System.out.println("\u001B[1;97m\u001B[4;37mUnderweight\n\n");
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Eat Nutrient-Dense Foods <--"); //green
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mFocus on foods that are rich in nutrients, such as lean proteins, whole grains, healthy fats, fruits, and vegetables. ");
						Thread.sleep(0100);
						System.out.print("These foods provide essential vitamins and minerals that support overall health.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Increase Calorie Intake <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mInclude sources of healthy fats in your diet, such as avocados, nuts, seeds, andolive oil. These fats are calorie-dense ");
						Thread.sleep(0100);
						System.out.print("and provide essential fatty acids necessary for various bodily functions.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Eat More Frequently <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mInstead of three large meals, consider eating smaller, more frequent meals throughout the day. This can make it easier ");
						Thread.sleep(0100);
						System.out.print("to increase your overall calorie intake.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Include Protein-Rich Foods <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mProtein is crucial for muscle development. Include sources of protein like lean meats, poultry, fish, eggs, dairy ");
						Thread.sleep(0100);
						System.out.print("products, legumes, and plant-based protein sources.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Stay Hydrated <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mAdequate hydration is essential for overall health. Drink water, milk, and otherhydrating beverages throughout the day, ");
						Thread.sleep(0100);
						System.out.print("but avoid excessive consumption before meals to prevent feeling overly full.");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						nav.nextLine();
						
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;36m");//cyan
						System.out.println("Tips");
						System.out.print("Classification: ");
						System.out.print("\u001B[0m");
						System.out.println("\u001B[1;97m\u001B[4;37mUnderweight\n\n");
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Strenght Training <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.print("\u001B[1;33mIncorporate strength training exercises into your routine to build muscle mass. This can help ensure that the weight you");
						Thread.sleep(0100);
						System.out.print("gain is in the form of lean muscle rather than just fat.");
						System.out.print("\u001B[0m");
						
						nav.nextLine();
						
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;32m");
						System.out.println("\u001B[1;33m ________________");
						System.out.println("\u001B[1;33m|                |");
						System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (3) Menu       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (4) Easy Mode  \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (5) Exit       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|________________|");
						System.out.print("\u001B[0m");
						
						try
						{
							last = Stop.nextInt();
						}
						
						catch(InputMismatchException e)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							Stop.nextLine();
							Stop.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue;
						}
						
						while(last < 1 || last > 5)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							nav.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue label;
						}
					
						switch(last)
						{
							case 1:
								continue;
							case 2:
								ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
							case 3:
								ShowMenu(about, decision, name, age, weight, height, Stop, nav);
							case 4:
								ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
							case 5:
								System.exit(0);
						}
						break;
					}	
				}
				
				else if(bmi <= 24.9)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;36m");
					System.out.println("Welcome to BMI Calculator");  
					System.out.println("Tips and Classication");
					System.out.println("\u001B[0m\n");
					
					System.out.print("\u001B[1;33mYour BMI is: ");
					System.out.print("\u001B[0m");
				
					System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi);
					System.out.println("\u001B[0m");
					
					System.out.print("\u001B[1;33mClassification: ");
					System.out.print("\u001B[0m");
					System.out.print("\u001B[1;97m\u001B[4;37mNormal");
					System.out.println("\u001B[0m\n\n");
					System.out.println("\u001B[1;32mPress Enter to Continue...");
					System.out.print("\u001B[0m");
					nav.nextLine();
					
					label: //normal
					while(true)
					{
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;36m");
						System.out.println("Tips");
						System.out.print("Classification: ");
						System.out.print("\u001B[0m");
						System.out.println("\u001B[1;97m\u001B[4;37mNormal\n\n");
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Balanced Meal <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mMaintain regular and balanced meal times to support your metabolism and energy levels. Aim for a combination of ");
						Thread.sleep(0100);
						System.out.print("carbohydrates, proteins, and fats in each meal to sustain energy throughout the day.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Eat Moderately <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mEnjoy a variety of foods in moderation, including treats and indulgences. This approach fosters a healthy relationship ");
						Thread.sleep(0100);
						System.out.print("with food and allows for flexibility in your diet.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Adequate Sleep <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mPrioritize sufficient and quality sleep to support physical and mental health. Establish a consistent sleep routine and ");
						Thread.sleep(0100);
						System.out.print("create a conducive sleep environment for restful nights.");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						
						nav.nextLine();
						
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;32m");
						System.out.println("\u001B[1;33m ________________");
						System.out.println("\u001B[1;33m|                |");
						System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (3) Menu       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (4) Easy Mode  \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (5) Exit       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|________________|");
						System.out.print("\u001B[0m");
						
						try
						{
							last = Stop.nextInt();
						}
						
						catch(InputMismatchException e)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							Stop.nextLine();
							Stop.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue;
						}
						
						while(last < 1 || last > 5)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							nav.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue label;
						}
					
						switch(last)
						{
							case 1:
								continue;
							case 2:
								ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
							case 3:
								ShowMenu(about, decision, name, age, weight, height, Stop, nav);
							case 4:
								ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
							case 5:
								System.exit(0);
						}
						break;
					}
				}
				
				else if(bmi <= 30)
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;36m");
					System.out.println("Welcome to BMI Calculator");
					System.out.println("Tips and Classication");
					System.out.println("\u001B[0m\n");
					
					System.out.print("\u001B[1;33mYour BMI is: ");
					System.out.print("\u001B[0m");
				
					System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi);
					System.out.println("\u001B[0m");
					
					System.out.print("\u001B[1;33mClassification: ");
					System.out.print("\u001B[0m");
					System.out.print("\u001B[1;97m\u001B[4;37mOverweight");
					System.out.println("\u001B[0m\n\n");
					System.out.println("\u001B[1;32mPress Enter to Continue...");
					System.out.print("\u001B[0m");
					nav.nextLine();
					
					label: //overweight
					while(true)
					{
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;36m");
						System.out.println("Tips");
						System.out.print("Classification: ");
						System.out.print("\u001B[0m");
						System.out.println("\u001B[1;97m\u001B[4;37mOverweight\n\n");
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Mindful Eating Habits <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mPay attention to portion sizes and practice mindful eating. Listen to your body's hunger and fullness cues, savor your ");
						Thread.sleep(0100);
						System.out.print("meals, and avoid distractions to prevent overeating.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Balanced Diet <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mFocus on a balanced diet with an emphasis on whole foods. Include a variety of fruits, vegetables, lean proteins, and ");
						Thread.sleep(0100);
						System.out.print("whole grains to ensure you meet your nutritional needs while managing calorie intake.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Regular Physical Activity <--\n");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.print("\u001B[1;33mIncorporate regular physical activity into your routine, choosing activities you enjoy. This helps with weight management ");
						Thread.sleep(0100);
						System.out.print("supports overall health and contributes to increased energy expenditure.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
			
						System.out.println("\u001B[1;32m--> Make A Change <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mImplement gradual and sustainable changes in your lifestyle. Small, consistent adjustments to your diet and exercise ");
						Thread.sleep(0100);
						System.out.print("routine are more likely to lead to long term success.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
											
						System.out.println("\u001B[1;32m--> Adequate Sleep <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mPrioritize sufficient and quality sleep. Lack of sleep can affect hormones that regulate hunger and satiety, potentially");
						Thread.sleep(0100);
						System.out.print("leading to overeating.");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
		
						nav.nextLine();
						
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;32m");
						System.out.println("\u001B[1;33m ________________");
						System.out.println("\u001B[1;33m|                |");
						System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (3) Menu       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (4) Easy Mode  \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (5) Exit       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|________________|");
						System.out.print("\u001B[0m");
						
						try
						{
							last = Stop.nextInt();
						}
						
						catch(InputMismatchException e)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							Stop.nextLine();
							Stop.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue;
						}
						
						while(last < 1 || last > 5)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							nav.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue label;
						}
					
						switch(last)
						{
							case 1:
								continue;
							case 2:
								ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
							case 3:
								ShowMenu(about, decision, name, age, weight, height, Stop, nav);
							case 4:
								ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
							case 5:
								System.exit(0);
						}
						break;
					}
				}
				
				else
				{
					System.out.print("\033[H\033[2J");
					System.out.println("\u001B[1;36m");
					System.out.println("Welcome to BMI Calculator");
					System.out.println("Tips and Classication");
					System.out.println("\u001B[0m\n");
					
					System.out.print("\u001B[1;33mYour BMI is: ");
					System.out.print("\u001B[0m");
				
					System.out.printf("\u001B[1;97m\u001B[4;37m%.2f" ,bmi);
					System.out.println("\u001B[0m");
					
					System.out.print("\u001B[1;33mClassification: ");
					System.out.print("\u001B[0m");
					System.out.print("\u001B[1;97m\u001B[4;37mObese");
					System.out.println("\u001B[0m\n\n");
					System.out.println("\u001B[1;32mPress Enter to Continue...");
					System.out.print("\u001B[0m");
					nav.nextLine();
					
					label: //obese
					while(true)
					{
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;36m");
						System.out.println("Tips");
						System.out.print("Classification: ");
						System.out.print("\u001B[0m");
						System.out.println("\u001B[1;97m\u001B[4;37mObese\n\n");
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Gradual Lifestyle Change <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mFocus on making gradual and sustainable lifestyle changes. Small adjustments to your diet and physical activity over ");
						Thread.sleep(0100);
						System.out.print("time can lead to lasting improvements in weight management.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Balanced Diet <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mPrioritize a balanced and nutritious diet, incorporating plenty of fruits, vegetables, lean proteins, and whole grains. ");
						Thread.sleep(0100);
						System.out.print("Aim for moderation rather than strict restriction to ensure a well-rounded intake of essential nutrients.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Regular Physical Activity <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mIncorporate regular exercise into your routine, choosing activities that you enjoy and can sustain over the long term. ");
						Thread.sleep(0100);
						System.out.print("Aim for a mix of cardiovascular exercise and strength training to support overall health.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Portion Control <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mPay attention to portion sizes and be mindful of serving sizes to avoid overeating. Utilize smaller plates and bowls to ");
						Thread.sleep(0100);
						System.out.print("help manage portion control effectively.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Stay hydrated <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mDrink plenty of water throughout the day. Sometimes, thirst can be mistaken for hunger, and adequate hydration supports ");
						Thread.sleep(0100);
						System.out.print("overall health and can assist in weight management.");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");
						
						nav.nextLine();
						
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;36m");
						System.out.println("Tips");
						System.out.print("Classification: ");
						System.out.print("\u001B[0m");
						System.out.println("\u001B[1;97m\u001B[4;37mObese\n\n");
						System.out.print("\u001B[0m");
						
						System.out.println("\u001B[1;32m--> Seek Professional Support <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mConsult with healthcare professionals, including a registered dietitian or a doctor specializing in obesity management. ");
						Thread.sleep(0100);
						System.out.print("They can provide personalized guidance, support, and monitoring.\n\n\n");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");

						System.out.println("\u001B[1;32m--> Set a Goal <--");
						System.out.print("\u001B[0m");
						Thread.sleep(0100);
						System.out.println("\u001B[1;33mEstablish realistic and achievable goals for weight loss. Small, incremental targets are more sustainable and can lead ");
						Thread.sleep(0100);
						System.out.print("to long-term success.");
						Thread.sleep(0100);
						System.out.print("\u001B[0m");

						nav.nextLine();
						
						System.out.print("\033[H\033[2J");
						System.out.println("\u001B[1;32m");
						System.out.println("\u001B[1;33m ________________");
						System.out.println("\u001B[1;33m|                |");
						System.out.println("\u001B[1;33m|\u001B[1;32m (1) Go Back    \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (2) Calculator \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (3) Menu       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (4) Easy Mode  \u001B[1;33m|");
						System.out.println("\u001B[1;33m|\u001B[1;32m (5) Exit       \u001B[1;33m|");
						System.out.println("\u001B[1;33m|________________|");
						System.out.print("\u001B[0m");
						
						try
						{
							last = Stop.nextInt();
						}
						
						catch(InputMismatchException e)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							Stop.nextLine();
							Stop.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue;
						}
						
						while(last < 1 || last > 5)
						{
							System.out.print("\033[H\033[2J");
							System.out.println("\u001B[1;91mPlease Choose Only 1-5");
							System.out.println("\u001B[0m");
							nav.nextLine();
							System.out.print("\033[H\033[2J");  
							System.out.flush();
							continue label;
						}
					
						switch(last)
						{
							case 1:
								continue;
							case 2:
								ShowCalculator(about, decision, name, age, weight, height, Stop, nav);
							case 3:
								ShowMenu(about, decision, name, age, weight, height, Stop, nav);
							case 4:
								ShowEasyMode(about, decision, name, age, weight, height, Stop, nav);
							case 5:
								System.exit(0);
						}
						break;
					}
				}
			} 
		}
		
		catch(InterruptedException e)
		{
			System.out.flush();
		}
		System.out.print("\033[H\033[2J");
	} 
}