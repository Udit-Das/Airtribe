# Git Workflow for Assignments

This guide explains how to use Git effectively for your Airtribe assignments.

## 🔄 Basic Workflow

### 1. Starting a New Assignment
```bash
# Create and switch to a new branch
git checkout -b assignment/week-X-assignment-name

# Or for specific topics
git checkout -b assignment/react-todo-app
git checkout -b assignment/data-analysis-week3
```

### 2. Working on Your Assignment
```bash
# Check status frequently
git status

# Add changes incrementally
git add file1.js file2.css
# Or add all changes
git add .

# Commit with descriptive messages
git commit -m "feat: add user authentication form"
git commit -m "fix: resolve styling issues in navbar"
git commit -m "docs: update README with setup instructions"
```

### 3. Pushing Your Work
```bash
# Push to your branch
git push origin assignment/week-X-assignment-name

# For the first push of a new branch
git push -u origin assignment/week-X-assignment-name
```

## 📝 Commit Message Conventions

### Format
```
type(scope): description

Examples:
feat(auth): add login functionality
fix(ui): correct button alignment
docs(readme): update installation steps
style(css): improve responsive design
test(api): add unit tests for user service
```

### Types
- **feat**: New feature
- **fix**: Bug fix
- **docs**: Documentation changes
- **style**: Code style changes
- **refactor**: Code refactoring
- **test**: Adding or updating tests
- **chore**: Maintenance tasks

## 🌿 Branching Strategy

### Branch Naming
```
assignment/week-number-topic
assignment/project-name
feature/specific-feature
fix/bug-description

Examples:
assignment/week-1-html-basics
assignment/week-5-react-calculator
assignment/final-project-ecommerce
```

### Keeping Branches Clean
```bash
# Before starting new work, switch to main
git checkout main
git pull origin main

# Create new branch from updated main
git checkout -b assignment/new-assignment
```

## 🔍 Reviewing Your Changes

```bash
# See what files changed
git status

# See exact changes
git diff

# See changes for specific file
git diff filename.js

# See commit history
git log --oneline
```

## 🚨 Common Issues and Solutions

### Accidentally committed to wrong branch
```bash
# Move last commit to correct branch
git log --oneline  # Find commit hash
git checkout correct-branch
git cherry-pick <commit-hash>
git checkout wrong-branch
git reset --hard HEAD~1
```

### Want to undo last commit
```bash
# Keep changes but undo commit
git reset --soft HEAD~1

# Remove changes and commit
git reset --hard HEAD~1
```

### Merge conflicts
```bash
# Pull latest changes
git pull origin main

# Resolve conflicts in files
# Edit files to fix conflicts

# Add resolved files
git add .

# Complete the merge
git commit -m "resolve merge conflicts"
```

## 📊 Best Practices

1. **Commit Early, Commit Often**: Make small, frequent commits
2. **Write Clear Messages**: Describe what and why, not how
3. **Test Before Committing**: Ensure code works before committing
4. **Keep Commits Atomic**: One logical change per commit
5. **Use Branches**: Never work directly on main branch
6. **Pull Before Push**: Always pull latest changes before pushing

## 🔧 Useful Git Aliases

Add these to your `~/.gitconfig`:

```ini
[alias]
    st = status
    co = checkout
    br = branch
    ci = commit
    ca = commit -a
    cm = commit -m
    lg = log --oneline --graph --decorate --all
    unstage = reset HEAD --
    last = log -1 HEAD
```

Usage:
```bash
git st           # Instead of git status
git co main      # Instead of git checkout main
git cm "message" # Instead of git commit -m "message"
```