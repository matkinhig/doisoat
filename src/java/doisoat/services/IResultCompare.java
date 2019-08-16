package doisoat.services;

import java.util.ArrayList;

import doisoat.models.VNPayModel;

public interface IResultCompare {
	void onSuccess(ArrayList<VNPayModel> list);
	void onError(ArrayList<VNPayModel> list);
}
