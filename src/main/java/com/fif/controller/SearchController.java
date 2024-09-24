package com.fif.controller;

import com.fif.entity.User;
import com.fif.service.Impl.UserServiceImpl;
import com.fif.service.UserService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import java.util.Set;


public class SearchController extends SelectorComposer<Component> {

    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox userListbox;

    @Wire
    private Label usernameLabel;

    @Wire
    private Label genderLabel;

    @Wire
    private Label birthdayLabel;

    @Wire
    private Label ageLabel;

    @Wire
    private Label roleLabel;

    private ListModelList<User> dataModel = new ListModelList<>();

    private UserService userService = new UserServiceImpl();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        userListbox.setModel(dataModel);
    }

    @Listen("onClick =  #searchButton; onOK = window")
    public void search() {
        String keyword = keywordBox.getValue();
        dataModel.clear();
        dataModel.addAll(userService.search(keyword));
    }

    @Listen("onSelect = #userListbox")
    public void showDetail() {
        Set<User> selection = dataModel.getSelection();
        User selected = selection.iterator().next();
        usernameLabel.setValue(selected.getUsername());
        genderLabel.setValue(selected.getGender());
        birthdayLabel.setValue(selected.getBirthday());
        ageLabel.setValue(selected.getAge().toString());
        roleLabel.setValue(selected.getRole());
    }
}
