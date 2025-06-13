FROM node:22-alpine AS builder
WORKDIR /client
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM node:22-alpine
WORKDIR /client
COPY --from=builder /client/.next ./.next
COPY --from=builder /client/public ./public
COPY --from=builder /client/package*.json ./
COPY --from=builder /client/node_modules ./node_modules
EXPOSE 3000
CMD ["npm", "start"]