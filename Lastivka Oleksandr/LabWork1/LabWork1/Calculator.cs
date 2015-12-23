using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace LabWork1
{
    public class Calculator
    {
        public int Add(string numbers)
        {
            if (String.IsNullOrWhiteSpace(numbers)) {
                return 0;
            }

            var parsedNumbers = this.ParseNumbersFromString(numbers);

            var negativeNumbers = parsedNumbers.Where(number => number < 0).ToArray();
            if (negativeNumbers.Length > 0) {
                var negativeNumbersAsStrings = negativeNumbers.Select(number => number.ToString());
                throw new LessThanZeroException(string.Join(",", negativeNumbersAsStrings));
            }

            return parsedNumbers.Where(number => number <= 1000).Sum();
        }               

        private int[] ParseNumbersFromString(string numbers)
        {
            var delimeters = this.DelimetersFromString(numbers).ToList();
            delimeters.AddRange(new[] { ",", "\n" });

            if (numbers.StartsWith("//")) {
                numbers = numbers.Substring(numbers.IndexOf('\n'));
            }

            var parsedNumbers = numbers.Split(delimeters.ToArray(), StringSplitOptions.RemoveEmptyEntries)
                          .Select(number => Convert.ToInt32(number)).ToArray();

            return parsedNumbers;
        }

        private List<string> DelimetersFromString(string s)
        {
            if (s.StartsWith("//")) {
                var delSubstring = s.Substring(0, s.IndexOf('\n')).Substring(2);
                
                if (delSubstring.Contains('[') && delSubstring.Contains(']') && delSubstring.Length > 1) {
                    Regex regex = new Regex(@"\[.*?\]");
                    var matches = regex.Matches(delSubstring);

                    var delimeters = new List<string>();
                    foreach (Match match in matches) {
                        delimeters.Add(match.Value);
                    }

                    for (int i = 0; i < delimeters.Count; ++i) {
                        delimeters[i] = delimeters[i].Substring(1, delimeters[i].Length - 2);
                    }

                    return delimeters;
                } else {
                    return new List<string> { delSubstring };
                }
            }
            return new List<string>();
        }
    }
}
