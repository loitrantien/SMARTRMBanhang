package com.dnu.loi.smartrm.ui.adddishes;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.adddishes.AddDishesBL;
import com.dnu.loi.smartrm.dl.adddishes.AddDishesDL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.ui.base.BaseDialog;
import com.dnu.loi.smartrm.ui.dialog.SimpleListDialog;
import com.dnu.loi.smartrm.utils.DataBaseHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.List;

public class AddDishesDialog extends BaseDialog implements IAddDishesView {

    private EditText etName, etPrice;

    private ImageView ivBack;

    private TextView tvSave, tvType;

    private LinearLayout llType;

    private IAddDishesPresenter presenter;

    private onSaveDishesSuccess callback;

    private DishesType dishesType;

    private int itemPos;

    private DishesTypeAdapter adapter;

    public static AddDishesDialog newInstance(onSaveDishesSuccess callback) {
        AddDishesDialog dialog = new AddDishesDialog();
        dialog.callback = callback;

        return dialog;
    }

    @Override
    protected int getLayoutInflate() {
        return R.layout.dialog_add_dishes;
    }

    @Override
    protected DisplayMetrics getDisplayMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();

        int height = UIHelper.getScreenSize(getActivity()).heightPixels - 30;
        int width = UIHelper.getScreenSize(getActivity()).widthPixels;

        metrics.widthPixels = width;
        metrics.heightPixels = height;
        return metrics;
    }

    @Override
    protected void mappingView(View view) {
        etName = findViewById(R.id.etDishesName);
        etPrice = findViewById(R.id.etDishesPrice);
        tvType = findViewById(R.id.tvDishesType);
        tvSave = findViewById(R.id.tvSave);
        llType = findViewById(R.id.llDishesType);
        ivBack = findViewById(R.id.ivBack);
    }

    @Override
    protected void onBindView() {
        presenter.initDishesTypeList();
    }

    @Override
    protected void setViewEvent() {
        tvSave.setOnClickListener(v -> presenter.saveDishes(getDishes()));
        ivBack.setOnClickListener(v -> dismiss());
        tvType.setOnClickListener(v -> showDishesTypeList());
    }

    @Override
    protected void onViewAttach() {
        presenter = new AddDishesPresenter(new AddDishesBL(new AddDishesDL()));
        presenter.onViewAttach(this);
    }

    @Override
    protected void onViewDestroy() {
        presenter.onViewDestroy();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showError(String message) {
        runOnUiThread(() ->
                UIHelper.ToastShort(message));

    }

    @Override
    public void setDishesTypeList(List<DishesType> typeList) {
        adapter = new DishesTypeAdapter(typeList, 0);
        tvType.setText(typeList.get(0).getName());
        dishesType = typeList.get(0);
    }

    @Override
    public void showDishesTypeList() {
        SimpleListDialog<DishesType> dialog = new SimpleListDialog<>();
        dialog.setTitle(getString(R.string.dishes_type));
        adapter.setCurrentItemPosition(itemPos);
        dialog.setInstance(adapter, dishesType -> {
            this.dishesType = dishesType;
            tvType.setText(dishesType.getName());
            itemPos = adapter.getCurrentItemPosition();
        });
        dialog.show(getFragmentManager(), null);
    }

    @Override
    public Dishes getDishes() {
        Dishes dishes = new Dishes();
        dishes.setId(DataBaseHelper.getNewDishesId());
        dishes.setName(etName.getText().toString());
        dishes.setPrice(Double.valueOf(etPrice.getText().toString()));
        dishes.setUnit("khác");
        dishes.setId_type(dishesType.getId());
        return dishes;
    }

    @Override
    public void onSaveDishesSuccess() {
        callback.onSuccess(getDishes());
        dismiss();
    }
}
