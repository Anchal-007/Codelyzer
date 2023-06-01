import { AuthInterceptor } from './services/auth.interceptor';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavigationComponent } from './component/navigation/navigation.component';
import { FooterComponent } from './component/footer/footer.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';

import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './pages/home/home.component';
import { AdmindashboardComponent } from './pages/admin/admindashboard/admindashboard.component';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { ForgotPasswordComponent } from './pages/forgot-password/forgot-password.component';
import { ProfileComponent } from './pages/profile/profile.component';
import {MatListModule} from '@angular/material/list';
import { SideBarComponent} from './pages/admin/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { ViewCategoryComponent } from './pages/admin/view-category/view-category.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { UpdateCategoryComponent } from './pages/admin/update-category/update-category.component';
import { ViewQuizzesComponent } from './pages/admin/view-quizzes/view-quizzes.component';
import { AddQuizComponent } from './pages/admin/add-quiz/add-quiz.component';
import { UpdateQuizComponent } from './pages/admin/update-quiz/update-quiz.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import { ViewQuestionComponent } from './pages/admin/view-question/view-question.component';
import { AddQuestionComponent } from './pages/admin/add-question/add-question.component';
// import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { UpdateQuestionComponent } from './pages/admin/update-question/update-question.component';
import { UserSidebarComponent } from './pages/user/user-sidebar/user-sidebar.component';
import { UserWelcomepageComponent} from './pages/user/user-welcomepage/user-welcomepage.component';
import { UserProfileComponent } from './pages/user/user-profile/user-profile.component';
import { ViewAllQuizzesComponent } from './pages/user/view-all-quizzes/view-all-quizzes.component';
import { InstructionComponent } from './pages/user/instruction/instruction.component';
import { StartQuizComponent } from './pages/user/start-quiz/start-quiz.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
// import { DisableRightClickDirective } from './pages/admin/DisableRightClickDirective'
import { MatLineModule } from '@angular/material/core';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FooterComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    AdmindashboardComponent,
    UserdashboardComponent,
    ForgotPasswordComponent,
    ProfileComponent,
    SideBarComponent,
    WelcomeComponent,
    ViewCategoryComponent,
    AddCategoryComponent,
    UpdateCategoryComponent,
    ViewQuizzesComponent,
    AddQuizComponent,
    UpdateQuizComponent,
    ViewQuestionComponent,
    AddQuestionComponent,
    UpdateQuestionComponent,
    UserSidebarComponent,
    UserWelcomepageComponent,
    UserProfileComponent,
    ViewAllQuizzesComponent,
    InstructionComponent,
    StartQuizComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    // CKEditorModule,
    MatProgressSpinnerModule,
    MatLineModule
  
    
  ],


  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
