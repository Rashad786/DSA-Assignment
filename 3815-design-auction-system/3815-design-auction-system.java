class Bid {
    int userId;
    int amount;

    public Bid(int userId, int amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
class AuctionSystem {
    Map<Integer, Map<Integer, Integer>> bids;
    Map<Integer, TreeSet<Bid>> orderedBids;
    public AuctionSystem() {
        bids = new HashMap<>();
        orderedBids = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        bids.putIfAbsent(itemId, new HashMap<>());
        orderedBids.putIfAbsent(itemId, new TreeSet<>(
            (a,b) -> {
                if(a.amount != b.amount) return b.amount-a.amount;
                return b.userId-a.userId;
            }
        ));

        if(bids.get(itemId).containsKey(userId)) {
            int oldBid = bids.get(itemId).get(userId);
            orderedBids.get(itemId).remove(new Bid(userId, oldBid));
        }

        bids.get(itemId).put(userId, bidAmount);
        orderedBids.get(itemId).add(new Bid(userId, bidAmount));
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        int oldBid = bids.get(itemId).get(userId);
        orderedBids.get(itemId).remove(new Bid(userId, oldBid));

        bids.get(itemId).put(userId, newAmount);
        orderedBids.get(itemId).add(new Bid(userId, newAmount));
    }
    
    public void removeBid(int userId, int itemId) {
        int bid = bids.get(itemId).get(userId);

        bids.get(itemId).remove(userId);
        orderedBids.get(itemId).remove(new Bid(userId, bid));

        if(bids.get(itemId).isEmpty()) {
            bids.remove(itemId);
            orderedBids.remove(itemId);
        }
    }
    
    public int getHighestBidder(int itemId) {
        if(!orderedBids.containsKey(itemId) || orderedBids.get(itemId).isEmpty()) return -1;

        return orderedBids.get(itemId).first().userId;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */