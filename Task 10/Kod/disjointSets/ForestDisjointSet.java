package disjointSets;

public class ForestDisjointSet implements DisjointSet{
    private ForestDisjointSet parent;
    private int rank;

    public void makeSet() {
        this.parent = this;
        this.rank = 0;
    }

    public ForestDisjointSet findSet() {
        if (this != this.parent) {
            this.parent = this.parent.findSet();
        }

        return this.parent;
    }

    public boolean isDisjoint(ForestDisjointSet member) {
        if (member == null){
            throw new IllegalArgumentException();
        }

        return this.findSet() != member.findSet();
    }

    public boolean join(ForestDisjointSet member) {
        if (!this.isDisjoint(member)) {
            return false;
        }

        link(this.findSet(), member.findSet());

        return true;
    }

    private void link(ForestDisjointSet first, ForestDisjointSet second) {
        if (first.rank > second.rank) {
            second.parent = first;
        } else {
            first.parent = second;

            if (first.rank == second.rank){
                second.rank += 1;
            }
        }
    }
}
