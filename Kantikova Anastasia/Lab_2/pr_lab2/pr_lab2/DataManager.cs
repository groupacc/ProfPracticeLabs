using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pr_lab2
{
    public static class DataManager
    {
        public static T CalculateSmallestSpread<T>(List<T> dataList) 
            where T : BaseValueCompareType
        {
            var sortedList = dataList.OrderBy(x => x.ValueDifference).ToList();
            return sortedList.First();
        }
    }
}
