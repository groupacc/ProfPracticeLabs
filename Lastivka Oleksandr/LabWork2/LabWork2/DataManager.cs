using System.Collections.Generic;
using System.Linq;

namespace LabWork2
{
    public class DataManager
    {
        public static ISpreadable FindSmallestSpread(IEnumerable<ISpreadable> data)
        {
            var sortedList = data.OrderBy(x => x.Spread);

            return sortedList.First();
        }
    }
}