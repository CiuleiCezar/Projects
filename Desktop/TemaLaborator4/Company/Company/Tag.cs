using System;
using System.Collections.Generic;
using System.Text;

namespace Company
{
    class Tag
    {
        
        public int ID { get; set; }
        public string HashTag { get; set;}
        public string UseCase { get; set; }

        public List<Bug> bugList= new List<Bug>();

        public Tag(int ID, string HashTag, string UseCase)
        {
            this.ID = ID;
            this.HashTag = HashTag;
            this.UseCase = UseCase;
        }

    }
}
