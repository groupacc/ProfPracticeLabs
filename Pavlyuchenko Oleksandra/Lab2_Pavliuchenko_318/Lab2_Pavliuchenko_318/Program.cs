using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.IO;

namespace Lab2_Pavliuchenko_318
{
    class Program
    {
        static void Main(string[] args)
        {
            String WeatherFilePath = "D:\\weather.dat";
            String FootballFilePath = "D:\\football.dat";

            String WeatherRegex = @"^\s+(\d+)\s+(\d+)\s+(\d+)";
            String FootballRegex = @"^\s+\d+\.\s+(\w+)\s+\d+\s+\d+\s+\d+\s+\d+\s+(\d+)\s+\-\s+(\d+)";

            try
            {
                // part 1
                Console.WriteLine("-----1 part-----");
                WeatherProcessing WeatProcessing = new WeatherProcessing(WeatherFilePath);
                Console.WriteLine(WeatProcessing);

                Console.WriteLine("\n");


                //part 2
                Console.WriteLine("-----2 part-----");
                GoalsProcessing GoalProcessing = new GoalsProcessing(FootballFilePath);
                Console.WriteLine(GoalProcessing);

                Console.WriteLine("\n");


                //part 3
                Console.WriteLine("-----3 part-----");

                DataProcessing WeatherProcessing = new DataProcessing(WeatherFilePath, WeatherRegex);
                Console.WriteLine("Day number\t Max temperature\t Min temperature\n" + WeatherProcessing);

                Console.WriteLine("");

                DataProcessing FootballProcessing = new DataProcessing(FootballFilePath, FootballRegex);
                Console.WriteLine("Team name\t Goals difference\n" + FootballProcessing);

            }
            catch(FileNotFoundException e)
            {
                Console.WriteLine(e.Message);            
            }

            Console.ReadLine();


        }
    }
}
