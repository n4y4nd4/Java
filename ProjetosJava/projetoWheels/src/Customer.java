
public class Customer {
    private String name = null;
    private String postcode = null;
    private int telephone = 0;
    private int customerId = 0;
    private String email = null;

    private static int customerCount = 1;

    public Customer(String cName, String pcode, int tel, String email){
        name = cName;
        postcode = pcode;
        telephone = tel;
        customerId = customerCount++;
        this.email = email;
    }

    public int getCustomerNumber(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    public String getPostcode(){
        return postcode;
    }

    public String getEmail() {
        return email;
    }
}
