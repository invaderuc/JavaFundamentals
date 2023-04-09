package Element;

public class Box {

    Integer coordinateX;
    Integer coordinateY;

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Box(Integer coordinateX, Integer coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
    public Boolean lookFor(Integer[][] matrix){

        Boolean exist = false;
        for(Integer i = 0; i < matrix.length; i++){

            if(matrix[i][0] == this.coordinateX && matrix[i][1] == this.coordinateY){
                exist = true;
            }
        }
        return exist;
    }
}