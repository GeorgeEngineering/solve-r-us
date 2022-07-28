## Removing commits
Remove a commit without changing the history. This is the safe way:
git revert --strategy resolve abc123

Removing a commit by changing the history. This is not recommended:
git reset --hard commit-id

Then  push the change to the remote
git push -f

## Doing a Squash
git rebase --interactive abc123

This will merge all the commits on top of what is in commit-hash abc123

git push -f origin

## Creating a new branch and checking out to that one:
git checkout -b feature/SOLVE-R-US-0001-implement-the-initial-structure-for-the-backend

## Pushing the feature branch to the remote repository
git push -u origin feature/SOLVE-R-US-0001-implement-the-initial-structure-for-the-backend

## Staging files to the local repository
git add file-names
git add --all

## Committing the changes
git commit -m "SOLVE-R-US-0001 - Adding the basic functionality for the backend"
git commit -m "SOLVE-R-US-0001 - Changing the structure of the project"

## Pushing the changes to the remote repository
git push