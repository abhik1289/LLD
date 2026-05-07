
//BAD EXAMPLE
class UserServices {

    async createUser(data:{email:string,password:string,name:string})
    {
        if(!data.email.includes("@"))
        {
            throw new Error("Invalid Email");
        }
        //save user
        console.log(data);

        //send email
        console.log("email send to",data.email);

    }
}

//GOOD EXAMPLE
//one class - one goal - one outcome

class UserValidation {
    async validateEmail(email:string)
    {
        if(!email.includes("@"))
        {
            throw new Error("Invalid Email");
        }
    }

}


class UserReposatory {
    async savedUser(data:{email:string,password:string,name:string})
    {
        //save user
    }
}

class UserSendEmail {
    async sendEmail(email:string)
    {
        //send email
    }
}

class User {
    userValidation: UserValidation;
    userReposatory: UserReposatory;
    userSendEmail: UserSendEmail;

    constructor(){
        this.userValidation = new UserValidation();
        this.userReposatory = new UserReposatory();
        this.userSendEmail = new UserSendEmail();
    }

    async register(data:{email:string,password:string,name:string}) {
        await this.userValidation.validateEmail(data.email);
        await this.userReposatory.savedUser(data);
        await this.userSendEmail.sendEmail(data.email);
    }
}