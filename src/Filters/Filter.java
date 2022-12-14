package Filters;

/**
 *
 * @author Alejandro Lagunes
 */
public abstract class Filter
{
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    private Filter next;
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    protected abstract Object process(Object entry);
    protected abstract Object process(Object entry1, Object entry2);
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    public Object execute(Object entry)
    {
        Object value = process(entry);
        if( this.next != null ) value = this.next.execute(value);
        return value;
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    public Object execute(Object entry1, Object entry2)
    {
        Object value = process(entry1, entry2);
        if( this.next != null ) value = this.next.execute(value);
        return value;
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    public void register(Filter filterNext)
    {
        if ( this.next == null )
        {
            this.next = filterNext;
        }
        else
        {
            this.next.register(filterNext);
        }
    }
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
}
