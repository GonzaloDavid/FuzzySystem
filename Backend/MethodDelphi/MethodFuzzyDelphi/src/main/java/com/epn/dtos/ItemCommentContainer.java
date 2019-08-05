/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.ItemCommentPK;

/**
 *
 * @author david
 */
public class ItemCommentContainer {
    private ItemCommentPK itemCommentPK;
    private String commentary;

    public ItemCommentContainer() {
    }

    public ItemCommentContainer(ItemCommentPK itemCommentPK, String commentary) {
        this.itemCommentPK = itemCommentPK;
        this.commentary = commentary;
    }

    public ItemCommentPK getItemCommentPK() {
        return itemCommentPK;
    }

    public void setItemCommentPK(ItemCommentPK itemCommentPK) {
        this.itemCommentPK = itemCommentPK;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
    
}
