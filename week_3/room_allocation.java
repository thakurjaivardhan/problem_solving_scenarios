package week_3;
class HostelRoom{
    public int beds,occupied;
    public String room_no;
    HostelRoom(String room_no, int beds, int occupied) {
    this.room_no = room_no;
    this.beds = beds;
    this.occupied = occupied;
    }
    boolean allot(String name){
        if(occupied<beds){
            occupied +=1;
            return true;
        }
        return false;
    }
    static HostelRoom findAvailableRooms(HostelRoom[] rooms){
        for(int i = 0;i<=rooms.length;i++){
            if (rooms[i].occupied<rooms[i].beds){
                return rooms[i];
            }
        }
        return null;
    }
    static void safeAllot(HostelRoom[] rooms,String studentName){
        HostelRoom room = HostelRoom.findAvailableRooms(rooms);
        if (room == null) {
            System.out.println("NO ROOMS AVAILABLE FOR "+studentName);
        }
        else{
            room.allot(studentName);
            System.out.println(studentName+" alloted to room "+ room.room_no );
        }
    }
}
public class room_allocation {

    public static void main(String[] args) {

        HostelRoom[] roomsWithSpace = {
            new HostelRoom("C-214", 3, 2),
            new HostelRoom("C-507", 2, 2)
        };

        HostelRoom.safeAllot(roomsWithSpace, "Divya");


        HostelRoom[] roomsFull = {
            new HostelRoom("C-214", 3, 3),
            new HostelRoom("C-507", 2, 2)
        };

        HostelRoom.safeAllot(roomsFull, "Divya");
    }
}
