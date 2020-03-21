using System;

namespace Company
{
    class Program
    {
        static void Main(string[] args)
        {

            var product = Product.GetProductById(2);
            product.InsertProduct("audi", "misto", "1.02.3");

        }
    }
}
