public class Student 
{
    private String name;
    private String code;
    private String mark;
    private String avatar;
    private String address;
    private String notes;
    
    public Student()
    {
        this("", "", "", "", "", "");
    }
    
    public Student(String name, String code, String mark, String avatar, String address, String notes)
    {
        this.name = name;
        this.code = code;
        this.mark = mark;
        this.avatar = avatar;
        this.address = address;
        this.notes = notes;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public String getMark()
    {
        return mark;
    }
    
    public void setMark(String mark)
    {
        this.mark = mark;    
    }
    
    public String getAvatar()
    {
        return avatar;
    }
    
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getNotes()
    {
        return notes;
    }
    
    public void setNotes(String notes)
    {
        this.notes = notes;
    }
}
