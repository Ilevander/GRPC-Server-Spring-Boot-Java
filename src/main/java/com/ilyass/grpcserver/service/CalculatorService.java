package com.ilyass.grpcserver.service;

import com.ilyass.grpcserver.Calculator;
import com.ilyass.grpcserver.CalculatorServiceGrpc;
import io.grpc.stub.StreamObserver;

public class CalculatorService extends CalculatorServiceGrpc.CalculatorServiceImplBase{

    @Override
    public void sum(Calculator.UnaryRequest request, StreamObserver<Calculator.UnaryResponse> responseObserver) {
        double a = request.getA();
        double b = request.getB();
        double result = a + b;
        Calculator.UnaryResponse response = Calculator.UnaryResponse.newBuilder().
                setA(a).
                setB(b).
                setResult(result).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
