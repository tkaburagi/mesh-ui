```shell script
git clone -b heroku https://github.com/tkaburagi/mesh-ui
rm -rf .git
heroku login
git init
git add .
git commit -m "first commit"
heroku create
```