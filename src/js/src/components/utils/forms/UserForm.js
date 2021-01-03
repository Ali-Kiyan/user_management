import React from "react";
import { Formik } from "formik";
import { Input, Button } from "antd";

const margin = {
  margin: "1% 0",
};

class UserForm extends React.Component {
  render() {
    return (
      <Formik
        initialValues={{ email: "", firstName: "", lastName: "", gender: "" }}
        validate={(values) => {
          const errors = {};
          if (!values.email) {
            errors.email = "Email Required";
          } else if (
            !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
          ) {
            errors.email = "Invalid email address";
          }
          if (!values.firstName) {
            errors.firstName = "First Name Required";
          }
          if (!values.lastName) {
            errors.lastName = "Last Name Required";
          }
          if (!values.gender) {
            errors.gender = "Gender Required";
          }else if(!["MALE", "FEMALE", "male", "female"].includes(values.gender)){
              errors.gender = 'Gender must be ("MALE", "FEMALE", "male", "female")'
          }
          return errors;
        }}
        onSubmit={(values, { setSubmitting }) => {
          setTimeout(() => {
            alert(JSON.stringify(values, null, 2));
            setSubmitting(false);
          }, 400);
        }}
      >
        {({
          values,
          errors,
          touched,
          handleChange,
          handleBlur,
          handleSubmit,
          isSubmitting,
          submitForm
        }) => (
          <form onSubmit={handleSubmit}>
            <Input
              style={margin}
              name="firstName"
              onChange={handleChange}
              onBlur={handleBlur}
              value={values.firstName}
              placeholder="First Name"
            />
            {errors.firstName && touched.firstName && errors.firstName}
            <Input
              style={margin}
              name="lastName"
              onChange={handleChange}
              onBlur={handleBlur}
              value={values.lastName}
              placeholder="Last Name"
            />
            {errors.lastName && touched.lastName && errors.lastName}
            <Input
              style={margin}
              name="email"
              type="email"
              onChange={handleChange}
              onBlur={handleBlur}
              value={values.email}
              placeholder="Email"
            />
            {errors.email && touched.email && errors.email}
            <Input
              style={margin}
              ƒ
              name="gender"
              onChange={handleChange}
              onBlur={handleBlur}
              value={values.gender}
              placeholder="Gender"
            />
            {errors.gender && touched.gender && errors.gender}
            <Button type="submit" disabled={isSubmitting} onClick={()=>submitForm()}>
              Submit
            </Button>
          </form>
        )}
      </Formik>
    );
  }
}

export default UserForm;
