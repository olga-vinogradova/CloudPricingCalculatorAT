package model;

import java.util.Objects;

public class ComputeEngine {
    private String numberOfInstances;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String gpuType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEngine(String numberOfInstances,String series, String machineType, boolean addGPUs, String gpuType,
                         int numberOfGPUs, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.series = series;
        this.machineType = machineType;
        this.addGPUs = addGPUs;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }
    public String getSeries(){
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public boolean isAddGPUs() {
        return addGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public int getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", series=" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", addGPUs=" + addGPUs +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs=" + numberOfGPUs +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return addGPUs == that.addGPUs && numberOfGPUs == that.numberOfGPUs && Objects.equals(numberOfInstances,
                that.numberOfInstances) && Objects.equals(series, that.series) &&
                Objects.equals(machineType, that.machineType) && Objects.equals(gpuType, that.gpuType)
                && Objects.equals(localSSD, that.localSSD) && Objects.equals(datacenterLocation, that.datacenterLocation)
                && Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(),getSeries(), getMachineType(), isAddGPUs(), getGpuType(),
                getNumberOfGPUs(), getLocalSSD(), getDatacenterLocation(), getCommittedUsage());
    }
}