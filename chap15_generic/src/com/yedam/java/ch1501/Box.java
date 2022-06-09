package com.yedam.java.ch1501;

public class Box<T, V, K> { // 제네릭 - 대문자 아무거나, 개수는 필요한 만큼
	T t;
	V v;
	K k;
	int num;
	
	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
	
	public void setV(V v) {
		this.v = v;
	}
	
	public V getV() {
		return v;
	}
	
	public void setK(K k) {
		this.k = k;
	}
	
	public K getK() {
		return k;
	}
}
