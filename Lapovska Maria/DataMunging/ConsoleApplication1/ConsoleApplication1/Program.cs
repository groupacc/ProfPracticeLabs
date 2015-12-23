using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace DataMunging
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Weather> weatherList = Parser.Parse("../../../weather.dat", (a, b, c) => new Weather(a, b, c));
            Driver(weatherList);

            List<Football> footballList = Parser.Parse("../../../football.dat", (a, b, c) => new Football(a, b, c));
            Driver(footballList);

            Console.ReadKey();
        }

        private static void Driver<T>(List<T> list) where T : BaseValueCompareType
        {
            T data = DataManager.CalculateSmallestSpread(list);
            Console.WriteLine(data.ToString());
        }
    }
}
