package com.yedam.java.ch1501_1;

public class Box<T, V, K> {
	// 필드
	T t;
	V v;
	K k;
	int num;

	// 게터 세터
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
