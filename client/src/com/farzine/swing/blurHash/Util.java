//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.swing.blurHash;

class Util {
    Util() {
    }

    private static double signPow(double value, double exp) {
        return Math.copySign(Math.pow(Math.abs(value), exp), value);
    }

    static void decodeDC(String str, double[] color) {
        int dcValue = Base83.decode(str);
        color[0] = SRGB.toLinear(dcValue >> 16);
        color[1] = SRGB.toLinear(dcValue >> 8 & 255);
        color[2] = SRGB.toLinear(dcValue & 255);
    }

    static void decodeAC(String str, double realMaxValue, double[] color) {
        int acValue = Base83.decode(str);
        int quantR = acValue / 361;
        int quantG = acValue / 19 % 19;
        int quantB = acValue % 19;
        color[0] = signPow(((double)quantR - 9.0) / 9.0, 2.0) * realMaxValue;
        color[1] = signPow(((double)quantG - 9.0) / 9.0, 2.0) * realMaxValue;
        color[2] = signPow(((double)quantB - 9.0) / 9.0, 2.0) * realMaxValue;
    }

    static long encodeDC(double[] value) {
        long r = (long)SRGB.fromLinear(value[0]);
        long g = (long)SRGB.fromLinear(value[1]);
        long b = (long)SRGB.fromLinear(value[2]);
        return (r << 16) + (g << 8) + b;
    }

    static long encodeAC(double[] value, double maximumValue) {
        double quantR = Math.floor(Math.max(0.0, Math.min(18.0, Math.floor(signPow(value[0] / maximumValue, 0.5) * 9.0 + 9.5))));
        double quantG = Math.floor(Math.max(0.0, Math.min(18.0, Math.floor(signPow(value[1] / maximumValue, 0.5) * 9.0 + 9.5))));
        double quantB = Math.floor(Math.max(0.0, Math.min(18.0, Math.floor(signPow(value[2] / maximumValue, 0.5) * 9.0 + 9.5))));
        return Math.round(quantR * 19.0 * 19.0 + quantG * 19.0 + quantB);
    }

    static void applyBasisFunction(int[] pixels, int width, int height, double normalisation, int i, int j, double[][] factors, int index) {
        double r = 0.0;
        double g = 0.0;
        double b = 0.0;

        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                double basis = normalisation * Math.cos(Math.PI * (double)i * (double)x / (double)width) * Math.cos(Math.PI * (double)j * (double)y / (double)height);
                int pixel = pixels[y * width + x];
                r += basis * SRGB.toLinear(pixel >> 16 & 255);
                g += basis * SRGB.toLinear(pixel >> 8 & 255);
                b += basis * SRGB.toLinear(pixel & 255);
            }
        }

        double scale = 1.0 / (double)(width * height);
        factors[index][0] = r * scale;
        factors[index][1] = g * scale;
        factors[index][2] = b * scale;
    }

    static double max(double[][] values) {
        double result = Double.NEGATIVE_INFINITY;

        for(int i = 1; i < values.length; ++i) {
            for(int j = 0; j < values[i].length; ++j) {
                if (values[i][j] > result) {
                    result = values[i][j];
                }
            }
        }

        return result;
    }
}
