import { StartQuizComponent } from './pages/user/start-quiz/start-quiz.component';
import { InstructionComponent } from './pages/user/instruction/instruction.component';
import { ViewAllQuizzesComponent } from './pages/user/view-all-quizzes/view-all-quizzes.component';
import { UserProfileComponent } from './pages/user/user-profile/user-profile.component';
import { UserWelcomepageComponent } from './pages/user/user-welcomepage/user-welcomepage.component';
import { AddQuestionComponent } from './pages/admin/add-question/add-question.component';
import { ViewQuestionComponent } from './pages/admin/view-question/view-question.component';
import { UpdateQuizComponent } from './pages/admin/update-quiz/update-quiz.component';
import { AddQuizComponent } from './pages/admin/add-quiz/add-quiz.component';
import { ViewQuizzesComponent } from './pages/admin/view-quizzes/view-quizzes.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { UserGuard } from './services/user.guard';
import { AdminGuard } from './services/admin.guard';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { AdmindashboardComponent } from './pages/admin/admindashboard/admindashboard.component';
import { SignupComponent } from './pages/signup/signup.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { ForgotPasswordComponent } from './pages/forgot-password/forgot-password.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { ViewCategoryComponent } from './pages/admin/view-category/view-category.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { UpdateCategoryComponent } from './pages/admin/update-category/update-category.component';
import { UpdateQuestionComponent } from './pages/admin/update-question/update-question.component';


const routes: Routes = [
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'home',component:HomeComponent,pathMatch:'full'},
  {path:'signup',component:SignupComponent,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'admin',component:AdmindashboardComponent,canActivate:[AdminGuard],
   children:[
    {
      path:'',component:WelcomeComponent,
        }, 
        {
          path:'home',component:WelcomeComponent,
            }, 
    {
     path:'profile',component:ProfileComponent,
       },
       {
        path:'categories',component:ViewCategoryComponent,
          },
          {
            path:'add-category',component:AddCategoryComponent,
              },
              {
                path:'updateCategory/:category_id',component:UpdateCategoryComponent,
                  },
                      {
                        path:'view-quizzes/:category_id',component:ViewQuizzesComponent
                      },
                      {
                        path:'add-quiz/:category_id',component:AddQuizComponent,
                          },
                          {
                            path:'updateQuiz/:quiz_id',component:UpdateQuizComponent,
                              },
                              {
                                path:'view-questions/:quiz_id/:title',component:ViewQuestionComponent,
                                  },
                                  {
                                    path:'add-question/:quiz_id/:title',component:AddQuestionComponent,
                                      },
                                      {
                                        path:'update-question/:quiz_id/:title',component:UpdateQuestionComponent,
                                          },
                                         ]},
  {path:'user',component:UserdashboardComponent,canActivate:[UserGuard],
    children:[{
      path:'',component:UserWelcomepageComponent,
    }, 
    {
      path:'home',component:UserWelcomepageComponent,
        }, 
        {
          path:'profile',component:UserProfileComponent,
        }, 
        {
          path:'quizzes/:category_id',component:ViewAllQuizzesComponent,
        }, 
        {
          path:'instructions/:quiz_id',component:InstructionComponent,
            },
          
    ]    
},
{path:'start-quiz/:quiz_id',component:StartQuizComponent,pathMatch:'full',canActivate:[UserGuard],},

  {path:'forgot-password',component:ForgotPasswordComponent,pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
