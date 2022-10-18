const RegisterEventService ={
    getCategorySelectObj:() => document.querySelectorAll("product-inputs")[0],
    getNameInputObj: () => document.querySelectorAll("product-inputs")[1],
    getPriceInputObj: () => document.querySelectorAll("product-inputs")[2],
    getRegistinfo: () => document.querySelector("regist-info"),
    getRegistButtonObj: () => document.querySelectorAll("regist-button"),
    getInfoTextareaObjs: () => document.querySelectorall("product-inputs")

    init: function() {
    this.getNameInputObj().disabled = true;
    this.getPriceInputObj().disabled = true;
    this.RegisButtonObj().disabled = true;

    },

   addCategorySelectEvent: function() {
        this.getCategorySelectObj.onchange = () => {
         if (this.getCategorySelectObj.value !="none") {
                this.getNameInputObj.disabled = false;
            }else {
                this.getNameInputObj.disabled = true;
            }
            RegisterObj.category = this.getCategorySelectObj().value;
         }
   },
   addNameInputEvent: function() {
           this.getNameInputObj.onkeyup = () => {
            if (this.getNameInputObj.value.length !="0") {
                   this.getPriceInputObj.disabled = false;
               }else {
                   this.getPriceInputObj.disabled = true;
               }
               RegisterObj.name = this.getNameInputObj().value;


            }
      },
   addPriceInputEvent: function() {
              this.getNameInputObj.onkeyup = () => {
              if (this.getPriceInputObj.value.length != 0) {
                     this.getRegistButtonObj.disabled = false;
                     this.getRegistinfo().classList.remove("regist-info-invisible");
                 }else {
                     this.getRegistButtonObj.disabled = true;
                     this.getRegistinfo().classList.add("regist-info-invisible");
                 }
                RegisterObj.price = this.getPriceInputObj().value;

                 }
         },
   addRegistButtonEvent: function() {
              this.getRegistButtonObj.onclick = () => {

                 console.log(RegisterObj);
                 RegisterObj.simpleInfo = this.getInfoTextareaObjs()[3]
                 RegisterObj.detailInfo = this.getInfoTextareaObjs()[4]
                 RegisterObj.optionInfo = this.getInfoTextareaObjs()[5]
                 RegisterObj.managementInfo = this.getInfoTextareaObjs()[6]
                 RegisterObj.shippingInfo = this.getInfoTextareaObjs()[7]
                    }
            }
   }
const RegisterRequestService = {
    createProductRequest: () => {
        let responseResult = null;

        $.ajax ({
            async: false,
            type: "POST",
            url: "/api/admin/products",
            contentType:"application/json",
            data: JSON.stringify(RegiserObj),
            dataType:"json",
            success: (response) => {
                responseResult = response.data;

            },
            error: (error) => {
                console.log(error);
            }

        });

        return responseResult;
    }
}



const RegisterObj = {
    category:null,
    name:null,
    price:null,
    simpleInfo:null,
    detailInfo:null,
    optionInfo:null,
    managementInfo:null,
    shippingInfo:null
}

const ProductRegistration = {
    RegisterObj:{
        category:null,
        name:null,
        price:null

    }

    initRegisterEvent: () => {
        RegisterEventService.init();
        RegisterEventService.addCategorySelectEvent();
        RegisterEventService.addNameInputEvent();
        RegisterEventService.addpriceInputEvent();
        RegisterEventService.addRegistButtonEvent();
        }
}

window.onload = () => {
    ProductRegistration.initRegisterEvent();

}
