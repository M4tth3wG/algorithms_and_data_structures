package disjointSets;

public class ListDisjointSet implements DisjointSet{
    private ListDisjointSet representativeMember;
    private ListDisjointSet nextMember;
    private ListDisjointSet lastMember;
    private int size;

    public void makeSet() {
        representativeMember = this;
        lastMember = this;
        nextMember = null;
        size = 1;
    }

    public ListDisjointSet findSet() {
        return this.representativeMember;
    }

    public boolean isDisjoint(ListDisjointSet member){
        if (member == null){
            throw new IllegalArgumentException();
        }

        return this.representativeMember != member.representativeMember;
    }

    public boolean join(ListDisjointSet member) {
        if (!this.isDisjoint(member)){
            return false;
        }

        if (this.representativeMember.size >= member.representativeMember.size) {
            link(this.representativeMember, member.representativeMember);
        } else {
            link(member.representativeMember, this.representativeMember);
        }

        return true;
    }

    private void link(ListDisjointSet first, ListDisjointSet second){
        first.lastMember.nextMember = second;
        first.lastMember = second.lastMember;

        for (ListDisjointSet set = second; set != null; set = set.nextMember){
            set.representativeMember = first;
        }

        first.size += second.size;
    }
}
