package ru.stqa.pft.addressbook.model;

public class GroupData {
    private String id;
    private String header;
    private String footer;
    private String name;

    public GroupData(String header, String footer, String name) {
        this.id = null;
        this.header = header;
        this.footer = footer;
        this.name = name;
    }

    public GroupData(String id, String header, String footer, String name) {
        this.id = id;
        this.header = header;
        this.footer = footer;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public String getName() {
        return name;
    }
}