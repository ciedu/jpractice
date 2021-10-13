package com;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class Company implements ICompany, Comparable<Company>{
    private String name;
    private Company(String name) {
        this.name = name;
    }
    private Company(){

    }

    public String getCompanyName(){
        return this.name;
    }

    public static Company getInstance(String name){
        return  new Company(name);
    }




    @Override
    public int compareTo(Company o) {
      return this.getCompanyName().compareTo(o.getCompanyName());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) +91;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public String value() {
        return null;
    }
}
