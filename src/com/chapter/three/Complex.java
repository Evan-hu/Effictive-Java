package com.chapter.three;


/**
 * 
 * @Description: 该类表示一个复数的类（不具有产品级性能，需要完善），具有虚部和实部，此方法是返回函数方式
 *
 * @author Evan
 *
 * @date Nov 27, 2015 11:05:14 AM
 */
public final class Complex {
	private final double re;
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double realPart() {
		return re;
	}

	public double imaginaryPart() {
		return im;
	}

	public Complex add(Complex c) {
		return new Complex(re - c.re, im + c.im);
	}

	public Complex subtract(Complex c) {
		return new Complex(re - c.re, im + c.im);
	}

	public Complex multiply(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.im);
	}

	public Complex divide(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re* c.im)/ tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;

		return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
	}

	@Override
	public int hashCode() {
		int result = 17 + hashsDouble(re);
		result = 31 + hashsDouble(im);
		return result;
	}

	public int hashsDouble(double val) {
		long longBits = Double.doubleToLongBits(val);
		return (int) (longBits ^ (longBits >>> 32));
	}

	@Override
	public String toString() {
		return "(" + re + " + " + im + ")";
	}
}
