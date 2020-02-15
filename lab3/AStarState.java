import java.util.HashMap;
import java.util.Iterator;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map. This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints." In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState {
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    /** Open waypoints */
    public HashMap<Location, Waypoint> openWaypoints;
    /** Close waypoints */
    public HashMap<Location, Waypoint> closeWaypoints;

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        this.openWaypoints = new HashMap<Location, Waypoint>();
        this.closeWaypoints = new HashMap<Location, Waypoint>();
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap() {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint with
     * the minimum total cost. If there are no open waypoints, this method returns
     * <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
        if (openWaypoints.isEmpty()) {
            return null;
        }

        Waypoint minCostWaypoint = null;
        Iterator<HashMap.Entry<Location, Waypoint>> it = this.openWaypoints.entrySet().iterator();

        while (it.hasNext()) {
            HashMap.Entry<Location, Waypoint> pair = it.next();
            Waypoint w = pair.getValue();

            if (minCostWaypoint == null || w.getTotalCost() < minCostWaypoint.getTotalCost()) {
                minCostWaypoint = w;
            }
        }

        return minCostWaypoint;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already in)
     * the "open waypoints" collection. If there is not already an open waypoint at
     * the new waypoint's location then the new waypoint is simply added to the
     * collection. However, if there is already a waypoint at the new waypoint's
     * location, the new waypoint replaces the old one <em>only if</em> the new
     * waypoint's "previous cost" value is less than the current waypoint's
     * "previous cost" value.
     **/
    public void addOpenWaypoint(Waypoint newWP) {
        Iterator<HashMap.Entry<Location, Waypoint>> it = this.openWaypoints.entrySet().iterator();
        Location newLocation = newWP.getLocation();
        Waypoint sameLocationWaypoint = null;

        while (sameLocationWaypoint == null && it.hasNext()) {
            HashMap.Entry<Location, Waypoint> pair = (HashMap.Entry<Location, Waypoint>) it.next();
            Location l = pair.getKey();

            if (l.equals(newLocation)) {
                sameLocationWaypoint = pair.getValue();
            }
        }

        if (sameLocationWaypoint == null || sameLocationWaypoint.getPreviousCost() > newWP.getPreviousCost()) {
            this.openWaypoints.put(newLocation, newWP);
        }
    }

    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints() {
        return this.openWaypoints.size();
    }

    /**
     * This method moves the waypoint at the specified location from the open list
     * to the closed list.
     **/
    public void closeWaypoint(Location loc) {
        Waypoint w = this.openWaypoints.get(loc);

        this.openWaypoints.remove(loc);
        this.closeWaypoints.put(loc, w);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint for
     * the specified location.
     **/
    public boolean isLocationClosed(Location loc) {
        return this.closeWaypoints.containsKey(loc);
    }
}
