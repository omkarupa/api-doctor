git add .
git commit -m "commit file batch created"

git push origin omkar-branch-1

git checkout main
git pull origin main

git merge omkar-branch-1

git push origin main

git checkout omkar-branch-1

git merge main

git push origin omkar-branch-1
