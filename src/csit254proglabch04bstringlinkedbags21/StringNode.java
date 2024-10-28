package csit254proglabch04bstringlinkedbags21;

/**
 * 
 *
 * @author Tyler Elvis 
 */
public class StringNode 
{

    private String data;
    private StringNode link;

    /**
     * The StringNode constructor takes in the data and sets it to the private
     * attributes
     *
     * @param initialData the data from the input
     * @param initalLink the link from the input
     */
    public StringNode(String initialData, StringNode initalLink) 
    {
        data = initialData;
        link = initalLink;
    }

    /**
     * The getData() method gets the data from the private attribute
     *
     * @return the data in data
     */
    public String getData() 
    {
        return data;
    }

    /**
     * The getLink() method gets the link from the private attribute
     *
     * @return the link
     */
    public StringNode getLink() 
    {
        return link;
    }

    /**
     * The setData() method sets the data from the input to the private
     * attribute
     *
     * @param newData sets to private attribute data
     */
    public void setData(String newData) 
    {
        data = newData;
    }

    /**
     * The setLink() method sets the link from the input to the private
     * attribute
     *
     * @param newLink sets to the private attribute link
     */
    public void setLink(StringNode newLink) 
    {
        link = newLink;
    }

}
