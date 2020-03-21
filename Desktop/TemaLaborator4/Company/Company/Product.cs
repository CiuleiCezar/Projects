using System.ComponentModel.DataAnnotations;
using System.Data;
using System.Data.SqlClient;

namespace Company
{
    class Product
    {
        private const string CONNECTION_STRING = "Server=DESKTOP-986JRQ9;Database=Company;Trusted_Connection=True;";

        [Key]
        public int ID { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string Version { get; set; }

        public Product(int ID, string Name, string Description, string Version)
        {
            this.ID = ID;
            this.Name = Name;
            this.Description = Description;
            this.Version = Version;
        }

        public void InsertProduct(string Name, string Description, string Version)
        {

            using (SqlConnection connection = new SqlConnection(CONNECTION_STRING))
            {
                connection.Open();

                using(SqlCommand command = connection.CreateCommand())
                {
                    command.CommandType = CommandType.Text;
                    command.CommandText = "INSERT INTO [dbo].[Product]([Name], [Description],[Version]) " +
                        "Values (@Name, @Description,  @Version)";
                    command.Parameters.AddWithValue("@Name", Name);
                    command.Parameters.AddWithValue("@Description", Description);
                    command.Parameters.AddWithValue("@Version", Version);

                    command.ExecuteNonQuery();
                }
            }

        }

        public static Product GetProductById(int id)
        {
            using (SqlConnection connection = new SqlConnection(CONNECTION_STRING))
            {
                connection.Open();

                using (SqlCommand command = connection.CreateCommand())
                {
                    command.CommandType = CommandType.Text;
                    command.CommandText = "SELECT *FROM [dbo].[Product] Where [ID]=@ID";
                    command.Parameters.AddWithValue("@ID", id);

                    SqlDataReader reader = command.ExecuteReader();

                    if (reader.HasRows)
                    {
                        reader.Read();
                        string name = (string)reader["Name"];
                        string description = (string)reader["Description"];
                        string version = (string)reader["Version"];

                        return new Product(id, name, description, version);
                    }

                }
            }

            return null;
        }

        public void DeleteProduct()
        {

            using (SqlConnection connection = new SqlConnection(CONNECTION_STRING))
            {
                connection.Open();

                using(SqlCommand command = connection.CreateCommand())
                {
                    command.CommandType = CommandType.Text;
                    command.CommandText = "DELETE FROM [dbo].[Product] Where [ID]=@ID";
                    command.Parameters.AddWithValue("@ID", ID);
                    command.ExecuteNonQuery();

                }
            }

        }

        public void UpdateProduct(string description, string version)
        {

            using (SqlConnection connection = new SqlConnection(CONNECTION_STRING))
            {
                connection.Open();

                using(SqlCommand command = connection.CreateCommand())
                {
                    command.CommandType = CommandType.Text;
                    command.CommandText = "UPDATE [dbo].[Product] SET [DESCRIPTION]=@DESCRIPTION, [VERSION]=@VERSION WHERE [ID]=@ID";
                    command.Parameters.AddWithValue("@ID", ID);
                    command.Parameters.AddWithValue("@Description", description);
                    command.Parameters.AddWithValue("@Version", version);
                    command.ExecuteNonQuery();
                }
            }
        }
    }
}
