public class BSTNode
{
    private String key;
    private String value;
    private BSTNode left, right;

    public BSTNode( String key, String value )
    {
        this.key = key;
        this.value = value;
    }


    public void put(String key, String value)
    {
        if ( key.compareTo( this.key ) < 0 )
        {

            if (left!=null)
                left.put( key, value );
            else
                left = new BSTNode( key, value );

        }
        else if (key.compareTo(this.key)> 0) {
            if (right != null)
                right.put(key, value);
            else
                right = new BSTNode(key, value);
        }
        else
            //uasdklf;laksjdf;laksjdf
            this.value = value;
    }


    public Object get(String key)
    {
        if(this.key.equals(key))
            return value;
        if ( key.compareTo( this.key ) < 0 )
            return left==null ? null:left.get(key);
        else
            return right== null ? null: right.get(key);
    }
}