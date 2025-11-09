public class Conversor {
    double ars;
    double mxn;
    double cop;
    double brl;



    public void upodateData(Conversiones data){
        this.ars = data.ars();
        this.mxn = data.mxn();
        this.cop = data.cop();
        this.brl = data.brl();
    }

    public double getFromUSDtoMXN(double value){
        return value * this.mxn;
    }

    public double getFromMXNtoUSD(double value){
        return value * (1/this.mxn);
    }

    public double getFromUSDtoARS(double value){
        return value * this.ars;
    }

    public double getFromARStoUSD(double value){
        return value * (1/this.ars);
    }

    public double getFromUSDtoBRL(double value){
        return value * this.brl;
    }

    public double getFromBRLtoUSD(double value){
        return value * (1/this.brl);
    }

    public double getFromUSDtoCOP(double value){
        return value * this.cop;
    }

    public double getFromCOPtoUSD(double value){
        return value * (1/this.cop);
    }
}
