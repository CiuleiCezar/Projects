using System;
using System.Collections.Generic;
using System.Text;

namespace Company
{
    class Bug
    {

        public int ID { get; set; }
        public int ProductID { get; set; }
        public string Description { get; set; }
        public string Status { get; set; }
        public string Priority { get; set; }
        public int FoundByID { get; set; }
        public int AssignedToID { get; set; }

        public List<Tag> tagList = new List<Tag>();

        public Bug(int ID, int ProductID, string Description, string Status, string Priority, int FoundByID, int AssignedToID)
        {
            this.ID = ID;
            this.ProductID = ProductID;
            this.Description = Description;
            this.Status = Status;
            this.Priority = Priority;
            this.FoundByID = FoundByID;
            this.AssignedToID = AssignedToID;
        }

        public Bug()
        {

        }
    }
}
