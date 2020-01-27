#! /usr/bin/python
# -*- coding:utf-8 -*-
# Created by hlwang at 2020/1/24


import xlrd
import json

def trans_excel_to_json(data_dir):
    wb = xlrd.open_workbook(data_dir)
    sheet = wb.sheet_by_index(0)
    data = []
    ncols = sheet.ncols
    nrows = sheet.nrows
    new_hosp_flag = True
    cur_row = 1
    while(cur_row < nrows):
        hosp_need = {}
        hosp_num = sheet.cell_value(cur_row, 0)
        hosp_area_num = sheet.cell_value(cur_row, 1)
        hosp_name = sheet.cell_value(cur_row, 2)
        hosp_address = sheet.cell_value(cur_row, 5)
        hosp_contant = str(sheet.cell_value(cur_row, 6))
        try:
            hosp_contantor = hosp_contant.split('/')[1]
        except IndexError:
            hosp_contantor = ''
        hosp_contant_phone = hosp_contant.split('/')[0]
        hosp_need['no'] = hosp_num
        hosp_need['areaNo'] = hosp_area_num
        hosp_need['showInfo'] = False
        hosp_need['name'] = hosp_name
        hosp_need['address'] = hosp_address
        hosp_need['contat'] = hosp_contantor
        hosp_need['mobile'] = str(hosp_contant_phone)
        items = []
        for item_num in range(1000):
            cur_item = dict()
            item_name = sheet.cell_value(cur_row + item_num, 3)
            item_amount = sheet.cell_value(cur_row + item_num, 4)
            if item_amount == u'-' or '':
                item_amount = u'若干'
            cur_item['name'] = item_name
            cur_item['amount'] = item_amount
            items.append(cur_item)
            try:
                if sheet.cell_value(cur_row + item_num + 1, 0) != '' or sheet.cell_value(cur_row + item_num + 1, 2) == '':
                    break
            except:
                break
        # contact info, no use now
        # contacts = []
        # for contact_num in range(10000):
        #     cur_contact = dict()
        #     contact_str = sheet.cell_value(cur_row + contact_num, 5)
        #     contactor = contact_str.split('/')[1]
        #     contact_phone = contact_str.split('/')[0]
        #     cur_contact['contat'] = contactor
        #     cur_contact['mobile'] = contact_phone
        #     contacts.append(cur_contact)
        #     if sheet.cell_value(cur_row + contact_num + 1, 0) != '' or sheet.cell_value(cur_row + contact_num + 1, 5) == '':
        #         break
        #
        # add_row = max(contact_num, item_num) + 1
        add_row = item_num + 1
        # print(add_row)
        cur_row += add_row
        hosp_need['items'] = items
        data.append(hosp_need)

    return data


data_dir = u'../doc/物资募集/物资募捐统计.xlsx'
data = trans_excel_to_json(data_dir)
with open('public/data.json', 'w') as json_name:
    json.dump(data, json_name, ensure_ascii=False, indent=4)



